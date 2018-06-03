package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.UserConfig;

public interface UserConfigRepository extends MongoRepository<UserConfig, String> {
}
