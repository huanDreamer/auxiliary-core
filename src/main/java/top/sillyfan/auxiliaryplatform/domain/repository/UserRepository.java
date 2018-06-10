package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.User;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    Page<User> findByType(Integer type, Pageable pageable);

    Page<User> findByTypeAndIdNotIn(Integer type, Collection<String> ids, Pageable pageable);

    List<User> findByTypeAndIdIn(Integer type, Collection<String> ids);

    List<User> findByType(Integer type);

    List<User> findByTypeAndStatusAndIdIn(Integer type, Integer status, Collection<String> ids);

    List<User> findBySuperUser(String id);

    List<User> findBySuperUserIn(List<String> id);

    Page<User> findByOnlineAndTypeAndIdNotIn(Integer onLine, Integer type, Collection<String> ids, Pageable pageable);

    Page<User> findBySuperUser(String id, Pageable pageable);

    User findByUsername(String username);
}
