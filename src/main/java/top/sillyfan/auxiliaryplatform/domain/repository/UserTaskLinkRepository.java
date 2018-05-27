package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLink;

import java.util.List;

public interface UserTaskLinkRepository extends MongoRepository<UserTaskLink, String> {

    List<UserTaskLink> findByTaskIdInAndStatus(List<String> taskIds, Integer status);
}