package top.sillyfan.auxiliaryplatform.domain.repository;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.Task;

import java.util.List;
import java.util.Set;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByStatus(Integer status);

    Page<Task> findByDemanderIdAndCreateTimeBetween(String demanderId, DateTime form, DateTime to, Pageable pageable);

    Page<Task> findByIdIn(List<String> ids, Pageable pageable);

    Page<Task> findByStatusAndDemanderIdIn(Integer status, Set<String> demanderIds, Pageable pageable);

    List<Task> findByDemanderIdAndCreateTimeBetween(String demanderId, DateTime from, DateTime to);

    List<Task> findByCreateTimeBetween(DateTime from, DateTime to);

    Page<Task> findAllByCreateTimeBetween(DateTime form, DateTime to, Pageable pageable);
}
