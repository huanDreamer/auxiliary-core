package top.sillyfan.auxiliaryplatform.service;

import top.sillyfan.auxiliaryplatform.common.BaseService;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.model.User;
import top.sillyfan.auxiliaryplatform.domain.model.repository.UserMapper;

import java.util.List;
import java.util.Optional;

public interface UserService extends BaseService<User, Long, UserMapper> {

    User findByUserName(String username);

    /**
     * 获取用户的顶级用户
     *
     * @param user
     * @return
     */
    Optional<User> getSuperUser(User user);

    List<User> findByTypeAndIdIn(Integer type, List<Long> ids);

    List<User> findByType(Integer type);

    List<User> findByTypeAndStatusAndIdIn(Integer type, Integer status, List<Long> ids);

    List<User> findBySuperUser(Long id);

    List<User> findBySuperUserIn(List<Long> ids);

    Page<User> findByTypeAndUsernameLike(Integer type, String name, PageRequest pageable);

    Page<User> findByTypeAndIdNotInAndUsernameLike(Integer type, List<Long> ids, String name, PageRequest pageable);

    Page<User> findByOnlineAndTypeAndIdNotInAndUsernameLike(Integer onLine, Integer type, List<Long> ids, String name, PageRequest pageable);

    Page<User> findBySuperUserAndUsernameLike(Long id, String name, PageRequest pageable);

}
