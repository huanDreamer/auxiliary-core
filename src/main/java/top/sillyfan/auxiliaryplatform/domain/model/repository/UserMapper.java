package top.sillyfan.auxiliaryplatform.domain.model.repository;

import org.apache.ibatis.annotations.Mapper;
import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;
import top.sillyfan.auxiliaryplatform.domain.model.User;
import top.sillyfan.auxiliaryplatform.domain.model.UserExample;

@Mapper
public interface UserMapper extends BaseMapper<User, Long, UserExample> {

}