package top.sillyfan.auxiliaryplatform.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sillyfan.auxiliaryplatform.common.BaseServiceImpl;
import top.sillyfan.auxiliaryplatform.domain.model.AccessToken;
import top.sillyfan.auxiliaryplatform.domain.model.AccessTokenExample;
import top.sillyfan.auxiliaryplatform.domain.model.repository.AccessTokenMapper;
import top.sillyfan.auxiliaryplatform.service.AccessTokenService;

@Service
public class AccessTokenServiceImpl extends BaseServiceImpl<AccessToken, String, AccessTokenMapper> implements AccessTokenService {

    @Override
    @Autowired
    public void setRepository(AccessTokenMapper repository) {
        super.setRepository(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public int countByUserIdAndType(Long userId, Integer type) {

        AccessTokenExample example = new AccessTokenExample();

        example.createCriteria().andUserIdEqualTo(userId).andTypeEqualTo(type).andExpireGreaterThan(DateTime.now());

        return repository.countByExample(example);
    }
}
