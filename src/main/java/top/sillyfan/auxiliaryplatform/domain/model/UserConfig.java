package top.sillyfan.auxiliaryplatform.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户的自定义配置
 */
@Data
@Builder
public class UserConfig {

    /*配置id 和用户id相同*/
    private String id;

    /********************** 客户配置 **********************/
    // 任务标题
    private String taskTitle;

    // 任务内容
    private String taskDescribe;

    // 任务出价
    private BigDecimal taskPrice;

    // 过期时间 秒
    private Integer taskExpire;

}
