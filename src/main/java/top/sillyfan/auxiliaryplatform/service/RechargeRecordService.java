package top.sillyfan.auxiliaryplatform.service;

import top.sillyfan.auxiliaryplatform.common.BaseService;
import top.sillyfan.auxiliaryplatform.domain.model.RechargeRecord;
import top.sillyfan.auxiliaryplatform.domain.model.repository.RechargeRecordMapper;

import java.math.BigDecimal;

public interface RechargeRecordService extends BaseService<RechargeRecord, Long, RechargeRecordMapper> {

    void saveRecord(Long operatorId, Long demanderId, BigDecimal oldBalance, BigDecimal newBalance);

}
