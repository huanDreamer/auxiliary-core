package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.Access;

import java.util.List;

public interface AccessRepository extends MongoRepository<Access, String> {

    Access findByDemanderIdAndAuxiliaryId(String demanderId, String auxiliaryId);

    List<Access> findByDemanderIdAndAuxiliaryIdIn(String demanderId, List<String> auxiliaryIds);

    Page<Access> findByAuxiliaryId(String auxiliaryId, Pageable pageable);
}
