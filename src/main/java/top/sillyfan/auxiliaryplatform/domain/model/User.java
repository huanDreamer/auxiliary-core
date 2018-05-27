package top.sillyfan.auxiliaryplatform.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import top.sillyfan.auxiliaryplatform.constants.UserDef;
import top.sillyfan.auxiliaryplatform.domain.model.extend.UserMore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Builder
public class User extends UserMore {

    @Id
    private String id;

    private String username;

    @JsonIgnore
    private String password;

    private String email;

    private Integer type;

    /*二级辅助才有的字段，表示他的上级用户*/
    private String superUser;

    // 余额
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;

    // 被冻结的余额
    @Builder.Default
    private BigDecimal frozenBalance = BigDecimal.ZERO;

    @JsonIgnore
    @Builder.Default
    private List<String> authorizes = new ArrayList<>();

    @Builder.Default
    private Integer status = UserDef.UserStatusEnum.Disabled.getCode();

    private Date lastPasswordResetDate;

    @JsonIgnore
    public BigDecimal getValidBalance() {
        return balance.subtract(frozenBalance);
    }
}
