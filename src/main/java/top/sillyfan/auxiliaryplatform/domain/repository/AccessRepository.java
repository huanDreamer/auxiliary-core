package top.sillyfan.auxiliaryplatform.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.sillyfan.auxiliaryplatform.domain.model.Access;

public interface AccessRepository extends MongoRepository<Access, String> {

    Access findByDemanderIdAndAuxiliaryId(String demanderId, String auxiliaryId);

}
