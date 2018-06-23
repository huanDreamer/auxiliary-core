package top.sillyfan.auxiliaryplatform.domain.repository;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLink;

import java.util.List;
import java.util.Optional;

public interface UserTaskLinkRepository extends MongoRepository<UserTaskLink, String> {


}