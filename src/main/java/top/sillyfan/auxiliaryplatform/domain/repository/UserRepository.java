package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
