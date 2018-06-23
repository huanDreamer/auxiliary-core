package top.sillyfan.auxiliaryplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.sillyfan.auxiliaryplatform.common.BaseServiceImpl;
import top.sillyfan.auxiliaryplatform.constants.SettlementDef;
import top.sillyfan.auxiliaryplatform.constants.TaskDef;
import top.sillyfan.auxiliaryplatform.domain.api.ApiResponseCode;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.exception.ResourceNotFoundException;
import top.sillyfan.auxiliaryplatform.domain.model.Settlement;
import top.sillyfan.auxiliaryplatform.domain.model.SettlementExample;
import top.sillyfan.auxiliaryplatform.domain.model.User;
import top.sillyfan.auxiliaryplatform.domain.model.repository.SettlementMapper;
import top.sillyfan.auxiliaryplatform.service.SettlementService;
import top.sillyfan.auxiliaryplatform.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SettlementServiceImpl extends BaseServiceImpl<Settlement, Long, SettlementMapper> implements SettlementService {

    @Autowired
    UserService userService;

    @Override
    @Autowired
    public void setRepository(SettlementMapper repository) {
        super.setRepository(repository);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Settlement> findByAuxiliaryId(Long auxiliary, PageRequest pageRequest) {

        SettlementExample example = new SettlementExample();

        example.createCriteria().andAuxiliaryIdEqualTo(auxiliary);

        int total = repository.countByExample(example);

        if (total == 0) {
            return Page.empty(pageRequest.getPage());
        }

        example.setOffset(pageRequest.getOffset());
        example.setLimit(pageRequest.getLimit());

        List<Settlement> settlements = repository.selectByExample(example);

        return Page.of(settlements, pageRequest.getPage(), total);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Settlement> findByDemanderIdAndUserType(Long demanderId, Integer userType, PageRequest pageRequest) {

        SettlementExample example = new SettlementExample();

        example.createCriteria().andDemanderIdEqualTo(demanderId).andUserTypeEqualTo(userType);

        int total = repository.countByExample(example);

        if (total == 0) {
            return Page.empty(pageRequest.getPage());
        }

        example.setOffset(pageRequest.getOffset());
        example.setLimit(pageRequest.getLimit());

        List<Settlement> settlements = repository.selectByExample(example);

        return Page.of(settlements, pageRequest.getPage(), total);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Settlement> findByAuxiliaryIdAndDemanderId(Long auxiliaryId, Long demanderId) {

        SettlementExample example = new SettlementExample();

        example.createCriteria().andAuxiliaryIdEqualTo(auxiliaryId).andDemanderIdEqualTo(demanderId);

        List<Settlement> settlements = repository.selectByExample(example);

        if (!CollectionUtils.isEmpty(settlements)) {
            return Optional.of(settlements.get(0));
        }

        return Optional.empty();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void increaseSettlement(Long auxiliaryId, Long demanderId, TaskDef.TaskStatusEnum taskStatus, SettlementDef.SettlementTypeEnum type) {
        User user = userService.findOne(auxiliaryId);

        // 查找当前用户和客户的结算信息
        Settlement currentSettlement = this.findByAuxiliaryIdAndDemanderId(auxiliaryId, demanderId).orElse(null);

        if (Objects.isNull(currentSettlement)) {
            currentSettlement = Settlement.build(auxiliaryId, user.getType(), demanderId);
            super.create(currentSettlement);
        }

        switch (type) {
            case UserComplete:
                currentSettlement.setUserComplete(currentSettlement.getUserComplete() + 1);
                break;
            case Complete:
                currentSettlement.setComplete(currentSettlement.getComplete() + 1);
                // 用户已经结算过一次，所以需要减去
                if (TaskDef.TaskStatusEnum.UserCompleted.equals(taskStatus)) {
                    currentSettlement.setUserComplete(currentSettlement.getUserComplete() - 1);
                }
                break;
        }

        super.update(currentSettlement);

        Optional.ofNullable(user.getSuperUser()).ifPresent(superUser -> {
            increaseSettlement(superUser, demanderId, taskStatus, type);
        });
    }

    @Override
    public void reduceSettlement(Long auxiliaryId, Long demanderId, Integer num) {
        // 查找当前用户和客户的结算信息
        Settlement currentSettlement = this.findByAuxiliaryIdAndDemanderId(auxiliaryId, demanderId)
                .orElseThrow(() -> new ResourceNotFoundException(ApiResponseCode.Api_1015));

        currentSettlement.setComplete(currentSettlement.getComplete() - num);

        super.update(currentSettlement);
    }
}
