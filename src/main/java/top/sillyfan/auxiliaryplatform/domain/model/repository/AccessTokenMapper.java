package top.sillyfan.auxiliaryplatform.domain.model.repository;

import org.apache.ibatis.annotations.Mapper;
import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;
import top.sillyfan.auxiliaryplatform.domain.model.AccessToken;
import top.sillyfan.auxiliaryplatform.domain.model.AccessTokenExample;

@Mapper
public interface AccessTokenMapper extends BaseMapper<AccessToken, Long, AccessTokenExample> {
}
