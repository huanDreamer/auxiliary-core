package top.sillyfan.auxiliaryplatform.domain.model.extend;

import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public abstract class SettlementMore {

    @Transient
    private String auxiliaryName;

    @Transient
    private String demanderName;
}
