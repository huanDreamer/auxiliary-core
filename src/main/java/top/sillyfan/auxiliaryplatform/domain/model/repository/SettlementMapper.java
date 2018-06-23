package top.sillyfan.auxiliaryplatform.domain.model.repository;

import org.apache.ibatis.annotations.Mapper;
import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;
import top.sillyfan.auxiliaryplatform.domain.model.Settlement;
import top.sillyfan.auxiliaryplatform.domain.model.SettlementExample;

@Mapper
public interface SettlementMapper extends BaseMapper<Settlement, Long, SettlementExample> {

}