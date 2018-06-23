package top.sillyfan.auxiliaryplatform.service;

import top.sillyfan.auxiliaryplatform.common.BaseService;
import top.sillyfan.auxiliaryplatform.constants.SettlementDef;
import top.sillyfan.auxiliaryplatform.constants.TaskDef;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.model.Settlement;
import top.sillyfan.auxiliaryplatform.domain.model.repository.SettlementMapper;

import java.util.Optional;

public interface SettlementService extends BaseService<Settlement, Long, SettlementMapper> {

    Page<Settlement> findByAuxiliaryId(Long auxiliary, PageRequest pageRequest);

    Page<Settlement> findByDemanderIdAndUserType(Long demanderId, Integer userType, PageRequest pageRequest);

    Optional<Settlement> findByAuxiliaryIdAndDemanderId(Long auxiliaryId, Long demanderId);


    /**
     * 增加结算
     */
    void increaseSettlement(Long auxiliaryId, Long demanderId, TaskDef.TaskStatusEnum taskStatus, SettlementDef.SettlementTypeEnum type);

    /**
     * 减少结算（只能减少完成的数量）
     *
     * @param auxiliaryId
     * @param demanderId
     * @param num
     */
    void reduceSettlement(Long auxiliaryId, Long demanderId, Integer num);
}
