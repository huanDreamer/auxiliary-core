package top.sillyfan.auxiliaryplatform.util;

import org.springframework.util.CollectionUtils;
import top.sillyfan.auxiliaryplatform.constants.TaskDef;
import top.sillyfan.auxiliaryplatform.domain.model.Task;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLink;
import top.sillyfan.auxiliaryplatform.domain.model.report.TaskReport;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReportUtil {

    /**
     * 计算task报表
     */
    public static TaskReport calcTaskReport(List<Task> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return TaskReport.empty();
        }

        TaskReport.TaskReportBuilder builder = TaskReport.builder();

        Map<TaskDef.TaskStatusEnum, List<Task>> taskMap = datas.stream()
                .collect(Collectors.groupingBy(q -> TaskDef.TaskStatusEnum.from(q.getStatus()), Collectors.toList()));

        // 总数
        builder.total(datas.size());

        // 初始化状态
        builder.initialize(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Enabled)).map(Collection::size).orElse(0));

        // 过期
        builder.expire(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Expire)).map(Collection::size).orElse(0));

        // 异常
        builder.exception(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Exception)).map(Collection::size).orElse(0));

        // 进行中
        builder.conducting(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Conducting)).map(Collection::size).orElse(0));

        // 完成的任务
        builder.completed(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Completed)).map(Collection::size).orElse(0));

        // 用户已完成
        builder.userCompleted(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.UserCompleted)).map(Collection::size).orElse(0));

        // 冻结
        builder.frozen(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Frozen)).map(Collection::size).orElse(0));

        // 未知状态
        builder.unkonwn(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Unknown)).map(Collection::size).orElse(0));

        // 花费 = 初始化 + 已完成 的花费总额
        Optional<Double> initCost = Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Enabled))
                .map(tasks -> tasks.stream().map(Task::getPrice).mapToDouble(BigDecimal::doubleValue).sum());

        Optional<Double> complateCost = Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Completed))
                .map(tasks -> tasks.stream().map(Task::getPrice).mapToDouble(BigDecimal::doubleValue).sum());

        builder.cost(BigDecimal.valueOf(initCost.orElse(0D)).add(BigDecimal.valueOf(complateCost.orElse(0D))));

        return builder.build();
    }

    /**
     * 计算用户的task报表
     */
    public static TaskReport calcUserTaskReport(List<UserTaskLink> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return TaskReport.empty();
        }

        TaskReport.TaskReportBuilder builder = TaskReport.builder();

        Map<TaskDef.TaskStatusEnum, List<UserTaskLink>> taskMap = datas.stream()
                .collect(Collectors.groupingBy(q -> TaskDef.TaskStatusEnum.from(q.getStatus()), Collectors.toList()));

        // 总数
        builder.total(datas.size());

        // 初始化状态
        builder.initialize(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Enabled)).map(Collection::size).orElse(0));

        // 过期
        builder.expire(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Expire)).map(Collection::size).orElse(0));

        // 异常
        builder.exception(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Exception)).map(Collection::size).orElse(0));

        // 进行中
        builder.conducting(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Conducting)).map(Collection::size).orElse(0));

        // 完成的任务
        builder.completed(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Completed)).map(Collection::size).orElse(0));

        // 用户已完成
        builder.userCompleted(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.UserCompleted)).map(Collection::size).orElse(0));

        // 未知状态
        builder.unkonwn(Optional.ofNullable(taskMap.get(TaskDef.TaskStatusEnum.Unknown)).map(Collection::size).orElse(0));

        return builder.build();
    }


}
