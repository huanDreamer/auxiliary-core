package top.sillyfan.auxiliaryplatform.domain.model.repository;

import org.apache.ibatis.annotations.Mapper;
import top.sillyfan.auxiliaryplatform.dao.mapper.BaseMapper;
import top.sillyfan.auxiliaryplatform.domain.model.RechargeRecord;
import top.sillyfan.auxiliaryplatform.domain.model.RechargeRecordExample;

@Mapper
public interface RechargeRecordMapper extends BaseMapper<RechargeRecord, Long, RechargeRecordExample> {

}