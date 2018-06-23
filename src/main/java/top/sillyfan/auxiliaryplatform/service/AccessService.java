package top.sillyfan.auxiliaryplatform.service;

import top.sillyfan.auxiliaryplatform.common.BaseService;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.model.Access;
import top.sillyfan.auxiliaryplatform.domain.model.User;
import top.sillyfan.auxiliaryplatform.domain.model.repository.AccessMapper;

import java.util.List;

public interface AccessService extends BaseService<Access, Long, AccessMapper> {

    Access findByDemanderIdAndAuxiliaryId(Long demanderId, Long auxiliaryId);

    List<Access> findByDemanderIdAndAuxiliaryIdIn(Long demanderId, List<Long> auxiliaryIds);

    Page<Access> findByAuxiliaryId(Long auxiliaryId, PageRequest pageable);

    /**
     * 接受对接申请
     */
    void acceptAccess(Access access, Integer status, User auxiliary, User demander);
}
