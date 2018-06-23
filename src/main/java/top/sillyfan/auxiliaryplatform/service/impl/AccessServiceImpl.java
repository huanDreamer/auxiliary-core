package top.sillyfan.auxiliaryplatform.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sillyfan.auxiliaryplatform.common.BaseServiceImpl;
import top.sillyfan.auxiliaryplatform.constants.AccessDef;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.model.Access;
import top.sillyfan.auxiliaryplatform.domain.model.AccessExample;
import top.sillyfan.auxiliaryplatform.domain.model.User;
import top.sillyfan.auxiliaryplatform.domain.model.UserConfig;
import top.sillyfan.auxiliaryplatform.domain.model.json.LongSet;
import top.sillyfan.auxiliaryplatform.domain.model.repository.AccessMapper;
import top.sillyfan.auxiliaryplatform.service.AccessService;
import top.sillyfan.auxiliaryplatform.service.UserConfigService;

import java.util.List;
import java.util.Objects;

@Service
public class AccessServiceImpl extends BaseServiceImpl<Access, Long, AccessMapper> implements AccessService {

    @Autowired
    UserConfigService userConfigService;

    @Override
    @Autowired
    public void setRepository(AccessMapper repository) {
        super.setRepository(repository);
    }

    @Override
    public Access findByDemanderIdAndAuxiliaryId(Long demanderId, Long auxiliaryId) {

        AccessExample example = new AccessExample();

        AccessExample.Criteria criteria = example.createCriteria();
        if(Objects.nonNull(demanderId)) {
            criteria.andDemanderIdEqualTo(demanderId);
        }
        if(Objects.nonNull(auxiliaryId)) {
            criteria.andAuxiliaryIdEqualTo(auxiliaryId);
        }

        List<Access> result = repository.selectByExample(example);

        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public List<Access> findByDemanderIdAndAuxiliaryIdIn(Long demanderId, List<Long> auxiliaryIds) {

        AccessExample example = new AccessExample();

        AccessExample.Criteria criteria = example.createCriteria();

        if (Objects.nonNull(demanderId)) {
            criteria.andDemanderIdEqualTo(demanderId);
        }
        if (CollectionUtils.isNotEmpty(auxiliaryIds)) {
            criteria.andAuxiliaryIdIn(auxiliaryIds);
        }

        return repository.selectByExample(example);
    }

    @Override
    public Page<Access> findByAuxiliaryId(Long auxiliaryId, PageRequest pageable) {

        AccessExample example = new AccessExample();

        example.createCriteria().andAuxiliaryIdEqualTo(auxiliaryId);

        int total = repository.countByExample(example);

        if (total == 0) {
            return Page.empty(pageable.getPage());
        }

        example.setOffset(pageable.getOffset());
        example.setLimit(pageable.getLimit());

        List<Access> result = repository.selectByExample(example);

        return Page.of(result, pageable.getPage(), total);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void acceptAccess(Access access, Integer status, User auxiliary, User demander) {

        // 保存申请列表
        access.setStatus(status);
        super.update(access);

        if (AccessDef.AccessStatusEnum.Access.match(status)) {
            // 用户对接更新
            UserConfig auxiliaryConfig = userConfigService.findOne(auxiliary.getId());

            Boolean createAuxiliaryConfig = Objects.isNull(auxiliaryConfig);

            if (Objects.isNull(auxiliaryConfig)) {
                auxiliaryConfig = UserConfig.buildDefault(auxiliary.getId());
            }

            if (Objects.isNull(auxiliaryConfig.getPreferDemanders())) {
                auxiliaryConfig.setPreferDemanders(new LongSet());
            }
            auxiliaryConfig.getPreferDemanders().add(access.getDemanderId());

            if(createAuxiliaryConfig) {
                userConfigService.create(auxiliaryConfig);
            } else {
                userConfigService.update(auxiliaryConfig);
            }

            // 客户对接更新
            UserConfig demanderConfig = userConfigService.findOne(demander.getId());

            Boolean createDemanderConfig = Objects.isNull(demanderConfig);

            if (Objects.isNull(demanderConfig)) {
                demanderConfig = UserConfig.buildDefault(demander.getId());
            }

            if (Objects.isNull(demanderConfig.getPreferAuxiliaries())) {
                demanderConfig.setPreferAuxiliaries(new LongSet());
            }
            demanderConfig.getPreferAuxiliaries().add(access.getAuxiliaryId());

            if(createDemanderConfig) {
                userConfigService.create(demanderConfig);
            } else {
                userConfigService.update(demanderConfig);
            }
        }

        if (AccessDef.AccessStatusEnum.Reject.match(status)) {
            // 用户对接更新
            UserConfig auxiliaryConfig = userConfigService.findOne(auxiliary.getId());

            Boolean createAuxiliaryConfig = Objects.isNull(auxiliaryConfig);

            if (Objects.isNull(auxiliaryConfig)) {
                auxiliaryConfig = UserConfig.buildDefault(auxiliary.getId());
            }
            if (CollectionUtils.isNotEmpty(auxiliaryConfig.getPreferDemanders())) {
                auxiliaryConfig.getPreferDemanders().remove(access.getDemanderId());

                if(createAuxiliaryConfig) {
                    userConfigService.create(auxiliaryConfig);
                } else {
                    userConfigService.update(auxiliaryConfig);
                }
            }

            // 客户对接更新
            UserConfig demanderConfig = userConfigService.findOne(demander.getId());

            Boolean createDemanderConfig = Objects.isNull(demanderConfig);

            if (Objects.isNull(demanderConfig)) {
                demanderConfig = UserConfig.buildDefault(demander.getId());
            }
            if (CollectionUtils.isNotEmpty(demanderConfig.getPreferAuxiliaries())) {

                demanderConfig.getPreferAuxiliaries().remove(access.getAuxiliaryId());

                if(createDemanderConfig) {
                    userConfigService.create(demanderConfig);
                } else {
                    userConfigService.update(demanderConfig);
                }
            }

        }
    }
}
