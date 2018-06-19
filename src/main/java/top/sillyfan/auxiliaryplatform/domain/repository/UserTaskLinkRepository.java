package top.sillyfan.auxiliaryplatform.domain.repository;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLink;

import java.util.List;
import java.util.Optional;

public interface UserTaskLinkRepository extends MongoRepository<UserTaskLink, String> {

    List<UserTaskLink> findByTaskIdInAndStatus(List<String> taskIds, Integer status);

    List<UserTaskLink> findByUserIdInAndCreateTimeBetween(List<String> userIds, DateTime from, DateTime to);

    Page<UserTaskLink> findByUserIdInAndCreateTimeBetween(List<String> userIds, DateTime from, DateTime to, Pageable pageable);

    List<UserTaskLink> findByTaskIdIn(List<String> taskIds);

    Page<UserTaskLink> findByUserIdInAndTaskIdInAndCreateTimeBetween(List<String> userIds, List<String> taskIds, DateTime from, DateTime to, Pageable pageable);

    Optional<UserTaskLink> findByTaskId(String taskId);
}