package top.sillyfan.auxiliaryplatform.domain.model.extend;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserTaskMore {

    private String demanderId;

    private String demanderName;

    private String taskName;

    private BigDecimal price;

}
