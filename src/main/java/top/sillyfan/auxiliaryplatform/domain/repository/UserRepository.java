package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    Page<User> findByType(Integer type, Pageable pageable);

    List<User> findByType(Integer type);

    List<User> findByTypeAndStatusAndIdIn(Integer type, Integer status, List<String> ids);

    long countBySuperUserIn(List<String> id);

    List<User> findBySuperUser(String id);

    List<User> findBySuperUserIn(List<String> id);

    Page<User> findByOnlineAndType(Integer onLine, Integer type, Pageable pageable);

    Page<User> findBySuperUser(String id, Pageable pageable);

    User findByUsername(String username);
}
