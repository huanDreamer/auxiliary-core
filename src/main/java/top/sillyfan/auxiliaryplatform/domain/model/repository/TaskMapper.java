package top.sillyfan.auxiliaryplatform.domain.model.repository;

import org.apache.ibatis.annotations.Mapper;
import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;
import top.sillyfan.auxiliaryplatform.domain.model.Task;
import top.sillyfan.auxiliaryplatform.domain.model.TaskExample;

@Mapper
public interface TaskMapper extends BaseMapper<Task, Long, TaskExample> {

}