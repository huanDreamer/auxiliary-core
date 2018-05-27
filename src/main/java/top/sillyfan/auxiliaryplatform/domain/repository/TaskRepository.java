package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.Task;

import java.util.List;
import java.util.Set;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByStatus(Integer status);

    Page<Task> findByDemanderId(String demanderId, Pageable pageable);

    Page<Task> findByStatusAndDemanderIdIn(Integer status, Set<String> demanderIds, Pageable pageable);


}
