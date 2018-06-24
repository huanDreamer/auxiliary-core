package top.sillyfan.auxiliaryplatform.domain.model.message;

import lombok.Builder;
import lombok.Data;

/**
 * 任务过期message
 */
@Data
@Builder
public class TaskExpireMessage implements DelayMessage {

    /*任务id*/
    private Long taskId;

    /*延时时长 秒*/
    private Integer delay;

}
