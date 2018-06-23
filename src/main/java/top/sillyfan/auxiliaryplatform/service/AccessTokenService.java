package top.sillyfan.auxiliaryplatform.service;

import top.sillyfan.auxiliaryplatform.common.BaseService;
import top.sillyfan.auxiliaryplatform.domain.model.AccessToken;
import top.sillyfan.auxiliaryplatform.domain.model.repository.AccessTokenMapper;

public interface AccessTokenService extends BaseService<AccessToken, String, AccessTokenMapper> {

    int countByUserIdAndType(Long userId, Integer type);

}
