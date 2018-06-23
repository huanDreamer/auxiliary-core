package top.sillyfan.auxiliaryplatform.domain.model.repository;

import org.apache.ibatis.annotations.Mapper;
import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;
import top.sillyfan.auxiliaryplatform.domain.model.Access;
import top.sillyfan.auxiliaryplatform.domain.model.AccessExample;

@Mapper
public interface AccessMapper extends BaseMapper<Access, Long, AccessExample> {

}