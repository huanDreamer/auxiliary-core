package top.sillyfan.auxiliaryplatform.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import top.sillyfan.auxiliaryplatform.domain.model.extend.UserTaskMore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class UserTaskLink extends UserTaskMore {

    @Id
    private String id;

    /*任务id 目前来说每个任务都只允许接受一次，但是不排除以后一个task由多人完成*/
    private String taskId;

    /*接受任务的用户id*/
    private String userId;

    /*状态同Task状态，默认为"进行中"*/
    private Integer status;

    private DateTime createTime;

    private DateTime updateTime;
}
