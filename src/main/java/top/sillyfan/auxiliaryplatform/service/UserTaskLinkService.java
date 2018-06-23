package top.sillyfan.auxiliaryplatform.service;

import org.joda.time.DateTime;
import top.sillyfan.auxiliaryplatform.common.BaseService;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLink;
import top.sillyfan.auxiliaryplatform.domain.model.repository.UserTaskLinkMapper;

import java.util.List;
import java.util.Optional;

public interface UserTaskLinkService extends BaseService<UserTaskLink, Long, UserTaskLinkMapper> {

    List<UserTaskLink> findTasks(List<Long> taskIds, Integer status, List<Long> userIds, DateTime from, DateTime to);

    Page<UserTaskLink> findTasksWithPage(List<Long> userIds, List<Long> taskIds, DateTime from, DateTime to, PageRequest pageable);

    Optional<UserTaskLink> findByTaskId(Long taskId);
}
