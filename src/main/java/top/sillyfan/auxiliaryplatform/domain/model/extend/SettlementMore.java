package top.sillyfan.auxiliaryplatform.domain.model.extend;

import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Transient;
import top.sillyfan.auxiliaryplatform.domain.model.Settlement;

@Data
public abstract class SettlementMore {

    @Transient
    private String auxiliaryName;

    @Transient
    private String demanderName;

    public static Settlement build(Long auxiliaryId, Integer userType, Long demanderId) {
        Settlement settlement = new Settlement();
        settlement.setAuxiliaryId(auxiliaryId);
        settlement.setUserType(userType);
        settlement.setDemanderId(demanderId);
        settlement.setComplete(0);
        settlement.setUserComplete(0);
        settlement.setUpdateTime(DateTime.now());
        return settlement;
    }
}
