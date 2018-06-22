package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.User;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {


    User findByUsername(String username);
}
