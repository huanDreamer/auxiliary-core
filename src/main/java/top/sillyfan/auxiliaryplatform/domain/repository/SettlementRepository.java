package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.Settlement;

import java.util.Optional;

public interface SettlementRepository extends MongoRepository<Settlement, String> {

    Page<Settlement> findByAuxiliaryId(String auxiliary, Pageable pageable);

    Page<Settlement> findByDemanderId(String demanderId, Pageable pageable);

    Optional<Settlement> findByAuxiliaryIdAndDemanderId(String auxiliaryId, String demanderId);
}