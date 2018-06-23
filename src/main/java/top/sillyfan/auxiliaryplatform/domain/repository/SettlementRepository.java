package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.Settlement;

import java.util.List;
import java.util.Optional;

public interface SettlementRepository extends MongoRepository<Settlement, String> {


}
