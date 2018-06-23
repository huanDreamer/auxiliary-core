package top.sillyfan.auxiliaryplatform.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sillyfan.auxiliaryplatform.common.BaseServiceImpl;
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
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserMapper> implements UserService {

    @Override
    @Autowired
    public void setRepository(UserMapper repository) {
        super.setRepository(repository);
    }

    public User insert(User user) {
        repository.insert(user);

        return user;
    }

    @Override
    public User findByUserName(String username) {

        UserExample example = new UserExample();

        example.createCriteria().andUsernameEqualTo(username);

        List<User> users = repository.selectByExample(example);

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

        if (Objects.nonNull(user.getSuperUser())) {
            User u1 = repository.selectByPrimaryKey(user.getSuperUser());

            return getSuperUser(u1);
        }

        return Optional.empty();
    }

    @Override
    public List<User> findByTypeAndIdIn(Integer type, List<Long> ids) {

        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();

        if (Objects.nonNull(type)) {
            criteria.andTypeEqualTo(type);
        }
        if (!CollectionUtils.isEmpty(ids)) {
            criteria.andIdIn(ids);
        }
        return repository.selectByExample(example);
    }

    @Override
    public List<User> findByType(Integer type) {
        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();

        if (Objects.nonNull(type)) {
            criteria.andTypeEqualTo(type);
        }

        return repository.selectByExample(example);
    }

    @Override
    public List<User> findByTypeAndStatusAndIdIn(Integer type, Integer status, List<Long> ids) {
        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();
        if (CollectionUtils.isNotEmpty(ids)) {
            criteria.andIdIn(ids);
        }
        if (Objects.nonNull(type)) {
            criteria.andTypeEqualTo(type);
        }
        if (Objects.nonNull(status)) {
            criteria.andStatusEqualTo(status);
        }

        return repository.selectByExample(example);
    }

    @Override
    public List<User> findBySuperUser(Long id) {
        UserExample example = new UserExample();

        if (Objects.nonNull(id)) {
            example.createCriteria().andSuperUserEqualTo(id);
        }
        return repository.selectByExample(example);
    }

    @Override
    public List<User> findBySuperUserIn(List<Long> ids) {
        UserExample example = new UserExample();

        if (CollectionUtils.isNotEmpty(ids)) {
            example.createCriteria().andSuperUserIn(ids);
        }
        return repository.selectByExample(example);
    }

    @Override
    public Page<User> findByTypeAndUsernameLike(Integer type, String name, PageRequest pageable) {

        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(type)) {
            criteria.andTypeEqualTo(type);
        }
        if (StringUtils.isNotBlank(name)) {
            criteria.andUsernameLike(MybatisUtil.like(name));
        }

        return findByExampleWithPage(example, pageable);
    }

    @Override
    public Page<User> findByTypeAndIdNotInAndUsernameLike(Integer type, List<Long> ids, String name, PageRequest pageable) {

        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();

        if (Objects.nonNull(type)) {
            criteria.andTypeEqualTo(type);
        }
        if (CollectionUtils.isNotEmpty(ids)) {
            criteria.andIdNotIn(ids);
        }
        if (StringUtils.isNotBlank(name)) {
            criteria.andUsernameLike(MybatisUtil.like(name));
        }

        return findByExampleWithPage(example, pageable);
    }

    @Override
    public Page<User> findByOnlineAndTypeAndIdNotInAndUsernameLike(Integer onLine, Integer type, List<Long> ids, String name, PageRequest pageable) {

        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();

        if (Objects.nonNull(onLine)) {
            criteria.andOnlineEqualTo(onLine);
        }
        if (Objects.nonNull(type)) {
            criteria.andTypeEqualTo(type);
        }
        if (CollectionUtils.isNotEmpty(ids)) {
            criteria.andIdNotIn(ids);
        }
        if (StringUtils.isNotBlank(name)) {
            criteria.andUsernameLike(MybatisUtil.like(name));
        }

        return findByExampleWithPage(example, pageable);
    }

    @Override
    public Page<User> findBySuperUserAndUsernameLike(Long id, String name, PageRequest pageable) {

        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();

        if (Objects.nonNull(id)) {
            criteria.andSuperUserEqualTo(id);
        }
        if (StringUtils.isNotBlank(name)) {
            criteria.andUsernameLike(MybatisUtil.like(name));
        }

        return findByExampleWithPage(example, pageable);
    }

    /**
     * 使用example查询并且分页
     *
     * @param example  example
     * @param pageable 分页参数
     * @return
     */
    private Page<User> findByExampleWithPage(UserExample example, PageRequest pageable) {

        int total = repository.countByExample(example);

        if (total == 0) {
            return Page.empty(pageable.getPage());
        }

        example.setOffset(pageable.getOffset());
        example.setLimit(pageable.getLimit());

        List<User> users = repository.selectByExample(example);

        return Page.of(users, pageable.getPage(), total);
    }
}
