package top.sillyfan.auxiliaryplatform.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 客户的自定义配置
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserConfig {

    // 默认
    public static final UserConfig Default = new UserConfig();

    /*配置id 和用户id相同*/
    private String id;

    /********************** 客户配置 **********************/
    // 任务标题
    private String taskTitle;

    // 任务内容
    private String taskDescribe;

    // 过期时间 秒
    private Integer taskExpire;


    /*********************** 辅助方配置 ***********************/
    // 对接了的客户方
    private List<String> preferDemanders;
}
