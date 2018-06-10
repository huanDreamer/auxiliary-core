package top.sillyfan.auxiliaryplatform.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.util.List;
import java.util.Set;

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

    // 对接了的用户
    private Set<String> preferAuxiliaries;


    /*********************** 辅助方配置 ***********************/
    // 对接了的客户方
    private Set<String> preferDemanders;

    @Transient
    public static UserConfig buildDefault(String id) {
        return UserConfig.builder()
                .id(id).build();
    }
}
