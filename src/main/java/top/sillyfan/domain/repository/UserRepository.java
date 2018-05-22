package top.sillyfan.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.domain.model.User;

public interface UserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
