package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
