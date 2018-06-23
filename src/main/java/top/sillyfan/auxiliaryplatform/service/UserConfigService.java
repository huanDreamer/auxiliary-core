package top.sillyfan.auxiliaryplatform.service;

import top.sillyfan.auxiliaryplatform.common.BaseService;
import top.sillyfan.auxiliaryplatform.domain.model.UserConfig;
import top.sillyfan.auxiliaryplatform.domain.model.repository.UserConfigMapper;

import java.util.Optional;

public interface UserConfigService extends BaseService<UserConfig, Long, UserConfigMapper> {

    Optional<UserConfig> getByUserId(Long userId);
}
