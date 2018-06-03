package top.sillyfan.auxiliaryplatform.domain.model.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskReport {

    // 总数 对于需求方来说，就是提交的数量，对于用户来说就是接受的数量
    private Integer total = 0;

    // 还未被领取
    private Integer initialize = 0;

    // 过期
    private Integer expire = 0;

    // 异常
    private Integer exception = 0;

    // 进行中的任务
    private Integer conducting = 0;

    // 完成的任务
    private Integer completed = 0;

    // 被冻结
    private Integer frozen = 0;

    // 未知状态
    private Integer unkonwn = 0;

    // 花费
    private BigDecimal cost = BigDecimal.ZERO;

    public static TaskReport empty() {
        return new TaskReport();
    }
}
