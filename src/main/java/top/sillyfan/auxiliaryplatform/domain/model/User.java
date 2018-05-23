package top.sillyfan.auxiliaryplatform.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {

    @Id
    private String id;

    private String username;

    private String password;

    private String email;

    private Integer type;

    @Builder.Default
    private List<String> authorizes = new ArrayList<>();

    @Builder.Default
    private Boolean enabled = true;

    private Date lastPasswordResetDate;
}
