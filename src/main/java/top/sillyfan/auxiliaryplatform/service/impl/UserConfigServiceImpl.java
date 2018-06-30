package top.sillyfan.auxiliaryplatform.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sillyfan.auxiliaryplatform.common.BaseServiceImpl;
import top.sillyfan.auxiliaryplatform.domain.model.JwtUser;
import top.sillyfan.auxiliaryplatform.domain.model.UserConfig;
import top.sillyfan.auxiliaryplatform.domain.model.UserConfigExample;
import top.sillyfan.auxiliaryplatform.domain.model.repository.UserConfigMapper;
import top.sillyfan.auxiliaryplatform.service.UserConfigService;

import java.util.List;
import java.util.Optional;

@Service
public class UserConfigServiceImpl extends BaseServiceImpl<UserConfig, Long, UserConfigMapper> implements UserConfigService {

    @Override
    @Autowired
    public void setRepository(UserConfigMapper repository) {
        super.setRepository(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserConfig> getByUserId(Long userId) {
        UserConfigExample example = new UserConfigExample();

        example.createCriteria().andUserIdEqualTo(userId);

        List<UserConfig> userConfigs = repository.selectByExample(example);

        if (CollectionUtils.isEmpty(userConfigs)) {
            return Optional.empty();
        }

        return Optional.of(userConfigs.get(0));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removePrefer(JwtUser operator, Long userId) {

        this.getByUserId(operator.getId()).ifPresent(userConfig -> {

            if (operator.isDemander()
                    && CollectionUtils.isNotEmpty(userConfig.getPreferAuxiliaries())) {
                userConfig.getPreferAuxiliaries().remove(userId);

                this.getByUserId(userId).ifPresent(auxiliaryConfig -> {
                    if (CollectionUtils.isNotEmpty(auxiliaryConfig.getPreferDemanders())) {
                        auxiliaryConfig.getPreferDemanders().remove(operator.getId());
                        this.update(auxiliaryConfig);
                    }
                });
            }

            if (operator.isSuperAuxiliary()
                    && CollectionUtils.isNotEmpty(userConfig.getPreferDemanders())) {
                userConfig.getPreferDemanders().remove(userId);

                this.getByUserId(userId).ifPresent(demanderConfig -> {
                    if (CollectionUtils.isNotEmpty(demanderConfig.getPreferAuxiliaries())) {
                        demanderConfig.getPreferAuxiliaries().remove(operator.getId());
                        this.update(demanderConfig);
                    }
                });
            }

            super.update(userConfig);
        });
    }
}
