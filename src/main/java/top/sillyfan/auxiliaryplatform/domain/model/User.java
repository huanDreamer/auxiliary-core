package top.sillyfan.auxiliaryplatform.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends UserMore {

    @Id
    private String id;

    private String username;

    @JsonIgnore
    private String password;

    private String email;

    private String qq;

    private String phone;

    private Integer type;

    // 备注
    private String mark;

    // 辅助在线状态 默认离线
    @Builder.Default
    private Integer online = UserDef.OnlineEnum.Offline.getCode();

    // 每单需要向平台付的价格
    private BigDecimal price;

    // 余额
    private BigDecimal balance;

    /*二三级用户才有的字段，表示他的上级用户*/
    private String superUser;

    @JsonIgnore
    @Builder.Default
    private List<String> authorizes = new ArrayList<>();

    @Builder.Default
    private Integer status = UserDef.UserStatusEnum.Disabled.getCode();

    private Integer acceptTaskStatus;

    private Date lastPasswordResetDate;
}
