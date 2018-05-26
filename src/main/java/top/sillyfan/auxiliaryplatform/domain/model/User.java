package top.sillyfan.auxiliaryplatform.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import top.sillyfan.auxiliaryplatform.constants.UserDef;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Builder
public class User {

    @Id
    private String id;

    private String username;

    @JsonIgnore
    private String password;

    private String email;

    private Integer type;

    // 余额
    private BigDecimal balance;

    @JsonIgnore
    @Builder.Default
    private List<String> authorizes = new ArrayList<>();

    @Builder.Default
    private Integer status = UserDef.UserStatusEnum.Disabled.getCode();

    private Date lastPasswordResetDate;
}
