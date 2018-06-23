package top.sillyfan.auxiliaryplatform.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sillyfan.auxiliaryplatform.common.BaseServiceImpl;
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
    public Optional<UserConfig> getByUserId(Long userId) {
        UserConfigExample example = new UserConfigExample();

        example.createCriteria().andUserIdEqualTo(userId);

        List<UserConfig> userConfigs = repository.selectByExample(example);

        if (CollectionUtils.isEmpty(userConfigs)) {
            return Optional.empty();
        }

        return Optional.of(userConfigs.get(0));
    }
}
