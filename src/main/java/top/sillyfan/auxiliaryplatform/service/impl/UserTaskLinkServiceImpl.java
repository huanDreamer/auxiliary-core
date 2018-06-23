package top.sillyfan.auxiliaryplatform.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.sillyfan.auxiliaryplatform.common.BaseServiceImpl;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLink;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLinkExample;
import top.sillyfan.auxiliaryplatform.domain.model.repository.UserTaskLinkMapper;
import top.sillyfan.auxiliaryplatform.service.UserTaskLinkService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserTaskLinkServiceImpl extends BaseServiceImpl<UserTaskLink, Long, UserTaskLinkMapper> implements UserTaskLinkService {

    @Override
    @Autowired
    public void setRepository(UserTaskLinkMapper repository) {
        super.setRepository(repository);
    }

    @Override
    public List<UserTaskLink> findTasks(List<Long> taskIds, Integer status, List<Long> userIds, DateTime from, DateTime to) {

        UserTaskLinkExample example = new UserTaskLinkExample();

        UserTaskLinkExample.Criteria criteria = example.createCriteria();

        if (!CollectionUtils.isEmpty(taskIds)) {
            criteria.andTaskIdIn(taskIds);
        }
        if (Objects.nonNull(status)) {
            criteria.andStatusEqualTo(status);
        }
        if (!CollectionUtils.isEmpty(userIds)) {
            criteria.andUserIdIn(userIds);
        }
        if (Objects.nonNull(from)) {
            criteria.andCreateTimeGreaterThan(from);
        }
        if (Objects.nonNull(to)) {
            criteria.andCreateTimeLessThanOrEqualTo(to);
        }

        return repository.selectByExample(example);
    }

    @Override
    public Page<UserTaskLink> findTasksWithPage(List<Long> userIds, List<Long> taskIds, DateTime from, DateTime to, PageRequest pageable) {

        UserTaskLinkExample example = new UserTaskLinkExample();

        UserTaskLinkExample.Criteria criteria = example.createCriteria();

        if (!CollectionUtils.isEmpty(userIds)) {
            criteria.andUserIdIn(userIds);
        }
        if (!CollectionUtils.isEmpty(taskIds)) {
            criteria.andTaskIdIn(taskIds);
        }
        if (Objects.nonNull(from)) {
            criteria.andCreateTimeGreaterThanOrEqualTo(from);
        }
        if (Objects.nonNull(to)) {
            criteria.andCreateTimeLessThanOrEqualTo(to);
        }

        int total = repository.countByExample(example);

        if (total == 0) {
            return Page.empty(pageable.getPage());
        }

        example.setOffset(pageable.getOffset());
        example.setLimit(pageable.getLimit());

        List<UserTaskLink> userTaskLinks = repository.selectByExample(example);

        return Page.of(userTaskLinks, pageable.getPage(), total);
    }

    @Override
    public Optional<UserTaskLink> findByTaskId(Long taskId) {

        UserTaskLinkExample example = new UserTaskLinkExample();

        example.createCriteria().andTaskIdEqualTo(taskId);

        List<UserTaskLink> userTaskLinks = repository.selectByExample(example);

        if (userTaskLinks.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(userTaskLinks.get(0));
    }
}
