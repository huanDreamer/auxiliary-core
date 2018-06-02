package top.sillyfan.auxiliaryplatform.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.sillyfan.auxiliaryplatform.domain.api.PagingResponse;
import top.sillyfan.auxiliaryplatform.domain.model.Task;
import top.sillyfan.auxiliaryplatform.domain.model.report.TaskReport;

/**
 * task 列表的返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskListResponse {

    private TaskReport report;

    private PagingResponse<Task> data;
}
