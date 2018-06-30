package top.sillyfan.auxiliaryplatform.service;

import top.sillyfan.auxiliaryplatform.common.BaseService;
import top.sillyfan.auxiliaryplatform.domain.model.JwtUser;
import top.sillyfan.auxiliaryplatform.domain.model.UserConfig;
import top.sillyfan.auxiliaryplatform.domain.model.repository.UserConfigMapper;

import java.util.Optional;

public interface UserConfigService extends BaseService<UserConfig, Long, UserConfigMapper> {

    Optional<UserConfig> getByUserId(Long userId);

    /**
     * 删除对接关系
     *
     * @param operator
     * @param userId
     */
    void removePrefer(JwtUser operator, Long userId);
}
