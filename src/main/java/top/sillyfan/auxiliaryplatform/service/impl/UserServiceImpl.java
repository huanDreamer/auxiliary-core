package top.sillyfan.auxiliaryplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.sillyfan.auxiliaryplatform.constants.UserDef;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.model.User;
import top.sillyfan.auxiliaryplatform.domain.model.UserExample;
import top.sillyfan.auxiliaryplatform.domain.model.repository.UserMapper;
import top.sillyfan.auxiliaryplatform.service.UserService;
import top.sillyfan.auxiliaryplatform.util.MybatisUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUserName(String username) {

        UserExample example = new UserExample();

        example.createCriteria().andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(example);

        if (CollectionUtils.isEmpty(users)) {
            return null;
        }

        return users.get(0);
    }

    @Override
    public Optional<User> getSuperUser(User user) {

        if (Objects.isNull(user)) {
            return Optional.empty();
        }

        if (UserDef.UserTypeEnum.Super_auxiliary.match(user.getType())) {
            return Optional.of(user);
        }

        if (Objects.nonNull(user.getSuperuser())) {
            User u1 = userMapper.selectByPrimaryKey(user.getSuperuser());

            return getSuperUser(u1);
        }

        return Optional.empty();
    }

    @Override
    public List<User> findByTypeAndIdIn(Integer type, List<Long> ids) {

        UserExample example = new UserExample();

        example.createCriteria().andTypeEqualTo(type).andIdIn(ids);
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> findByType(Integer type) {
        UserExample example = new UserExample();

        example.createCriteria().andTypeEqualTo(type);

        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> findByTypeAndStatusAndIdIn(Integer type, Integer status, List<Long> ids) {
        UserExample example = new UserExample();

        example.createCriteria().andTypeEqualTo(type).andIdIn(ids).andStatusEqualTo(status);

        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> findBySuperUser(Long id) {
        UserExample example = new UserExample();

        example.createCriteria().andSuperuserEqualTo(id);

        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> findBySuperUserIn(List<Long> ids) {
        UserExample example = new UserExample();

        example.createCriteria().andSuperuserIn(ids);

        return userMapper.selectByExample(example);
    }

    @Override
    public Page<User> findByTypeAndUsernameLike(Integer type, String name, PageRequest pageable) {

        UserExample example = new UserExample();

        example.createCriteria().andTypeEqualTo(type).andUsernameLike(MybatisUtil.like(name));

        int total = userMapper.countByExample(example);

        if(total == 0) {
            return Page.empty(pageable.getPage());
        }

        return null;
    }

    @Override
    public Page<User> findByTypeAndIdNotInAndUsernameLike(Integer type, List<String> ids, String name, PageRequest pageable) {
        return null;
    }

    @Override
    public Page<User> findByOnlineAndTypeAndIdNotInAndUsernameLike(Integer onLine, Integer type, List<String> ids, String name, PageRequest pageable) {
        return null;
    }

    @Override
    public Page<User> findBySuperUserAndUsernameLike(String id, String name, PageRequest pageable) {
        return null;
    }
}
