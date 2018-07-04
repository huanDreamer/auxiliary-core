package top.sillyfan.auxiliaryplatform.service;

import org.joda.time.DateTime;
import top.sillyfan.auxiliaryplatform.common.BaseService;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.model.Task;
import top.sillyfan.auxiliaryplatform.domain.model.User;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLink;
import top.sillyfan.auxiliaryplatform.domain.model.repository.TaskMapper;

import java.util.List;

public interface TaskService extends BaseService<Task, Long, TaskMapper> {

    List<Task> findByStatus(Integer status);

    Page<Task> findWithPage(Long demanderId, String phone, Integer status, List<Long> demanderIds, List<Long> auxiliaryIds, DateTime from, DateTime to, PageRequest pageable);

    List<Task> findByDemanderIdAndPhoneLikeAndCreateTimeBetween(Long demanderId, String phone, DateTime from, DateTime to);

    String accept(Long userId, Task task);

    Task create(Task task, User demander);

    Long complateTask(Task task, UserTaskLink userTaskLink);

    Long failTask(Task task, UserTaskLink userTaskLink);

    Long userComplateTask(Task task, UserTaskLink userTaskLink);

    /**
     * 任务过期设置
     *
     * @param taskId
     */
    void taskExpire(Long taskId);

    Page<Task> findByAuxiliaryIdAndStatus(Long id, Integer status, PageRequest page);
}
