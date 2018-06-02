package top.sillyfan.auxiliaryplatform.domain.model.extend;

import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class TaskMore {

    /*发布者*/
    @Transient
    private String demanderName;

    /*领取者*/
    @Transient
    private String auxiliaryName;
}
