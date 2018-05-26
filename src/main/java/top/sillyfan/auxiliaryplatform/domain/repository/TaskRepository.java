package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.Task;
import top.sillyfan.auxiliaryplatform.domain.model.User;

public interface TaskRepository extends MongoRepository<Task, String> {

    Page<Task> findByDemanderId(String demanderId, Pageable pageable);
}
