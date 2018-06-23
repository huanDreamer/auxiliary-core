package top.sillyfan.auxiliaryplatform.domain.model.repository;

import org.apache.ibatis.annotations.Mapper;
import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;
import top.sillyfan.auxiliaryplatform.domain.model.UserConfig;
import top.sillyfan.auxiliaryplatform.domain.model.UserConfigExample;

@Mapper
public interface UserConfigMapper extends BaseMapper<UserConfig, Long, UserConfigExample> {

}