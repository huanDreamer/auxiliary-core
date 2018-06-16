package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.User;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    Page<User> findByTypeAndUsernameLike(Integer type, String name, Pageable pageable);

    Page<User> findByTypeAndIdNotInAndUsernameLike(Integer type, Collection<String> ids, String name, Pageable pageable);

    List<User> findByTypeAndIdIn(Integer type, Collection<String> ids);

    List<User> findByType(Integer type);

    List<User> findByTypeAndStatusAndIdIn(Integer type, Integer status, Collection<String> ids);

    List<User> findBySuperUser(String id);

    List<User> findBySuperUserIn(List<String> id);

    Page<User> findByOnlineAndTypeAndIdNotInAndUsernameLike(Integer onLine, Integer type, Collection<String> ids, String name, Pageable pageable);

    Page<User> findBySuperUserAndUsernameLike(String id, String name, Pageable pageable);

    User findByUsername(String username);
}
