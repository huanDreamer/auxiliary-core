package top.sillyfan.auxiliaryplatform.domain.model.repository;

import org.apache.ibatis.annotations.Mapper;
import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLink;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLinkExample;

@Mapper
public interface UserTaskLinkMapper extends BaseMapper<UserTaskLink, Long, UserTaskLinkExample> {

}