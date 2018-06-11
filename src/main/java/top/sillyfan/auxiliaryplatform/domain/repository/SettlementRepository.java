package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.Settlement;

import java.util.List;
import java.util.Optional;

public interface SettlementRepository extends MongoRepository<Settlement, String> {

    Page<Settlement> findByAuxiliaryId(String auxiliary, Pageable pageable);

    Page<Settlement> findByDemanderIdAndAuxiliaryIdIn(String demanderId, List<String> auxiliaryIds, Pageable pageable);

    Optional<Settlement> findByAuxiliaryIdAndDemanderId(String auxiliaryId, String demanderId);
}
