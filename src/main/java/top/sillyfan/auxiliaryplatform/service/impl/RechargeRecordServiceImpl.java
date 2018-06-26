package top.sillyfan.auxiliaryplatform.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import top.sillyfan.auxiliaryplatform.common.BaseServiceImpl;
import top.sillyfan.auxiliaryplatform.domain.model.RechargeRecord;
import top.sillyfan.auxiliaryplatform.domain.model.repository.RechargeRecordMapper;
import top.sillyfan.auxiliaryplatform.service.RechargeRecordService;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class RechargeRecordServiceImpl extends BaseServiceImpl<RechargeRecord, Long, RechargeRecordMapper> implements RechargeRecordService {

    @Override
    @Autowired
    public void setRepository(RechargeRecordMapper repository) {
        super.setRepository(repository);
    }

    @Override
    public void saveRecord(Long operatorId, Long demanderId, BigDecimal oldBalance, BigDecimal newBalance) {

        // 金额不变
        if(Objects.isNull(newBalance)) {
            return;
        }

        if(Objects.isNull(oldBalance)) {
            oldBalance = BigDecimal.ZERO;
        }

        if(oldBalance.compareTo(newBalance) == 0) {
            return;
        }

        // 保存记录
        RechargeRecord rechargeRecord = new RechargeRecord();

        rechargeRecord.setDemanderId(demanderId);
        rechargeRecord.setOperator(operatorId);
        rechargeRecord.setMoney(newBalance.subtract(oldBalance));
        rechargeRecord.setCreateTime(DateTime.now());

        super.create(rechargeRecord);
    }
}
