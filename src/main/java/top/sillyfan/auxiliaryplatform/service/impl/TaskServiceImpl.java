package top.sillyfan.auxiliaryplatform.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.sillyfan.auxiliaryplatform.common.BaseServiceImpl;
import top.sillyfan.auxiliaryplatform.constants.SettlementDef;
import top.sillyfan.auxiliaryplatform.constants.TaskDef;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;
import top.sillyfan.auxiliaryplatform.domain.model.Task;
import top.sillyfan.auxiliaryplatform.domain.model.TaskExample;
import top.sillyfan.auxiliaryplatform.domain.model.User;
import top.sillyfan.auxiliaryplatform.domain.model.UserTaskLink;
import top.sillyfan.auxiliaryplatform.domain.model.repository.TaskMapper;
import top.sillyfan.auxiliaryplatform.service.*;
import top.sillyfan.auxiliaryplatform.util.MybatisUtil;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class TaskServiceImpl extends BaseServiceImpl<Task, Long, TaskMapper> implements TaskService {

    @Autowired
    UserService userService;

    @Autowired
    UserConfigService userConfigService;

    @Autowired
    SettlementService settlementService;

    @Autowired
    UserTaskLinkService userTaskLinkService;

    @Override
    @Autowired
    public void setRepository(TaskMapper repository) {
        super.setRepository(repository);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Task> findByStatus(Integer status) {

        TaskExample example = new TaskExample();

        example.createCriteria().andStatusEqualTo(status);

        return repository.selectByExample(example);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Task> findByDemanderIdAndPhoneLikeAndCreateTimeBetween(Long demanderId, String phone, DateTime from, DateTime to) {

        TaskExample example = new TaskExample();

        TaskExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(demanderId)) {
            criteria.andDemanderIdEqualTo(demanderId);
        }
        if (StringUtils.isNotBlank(phone)) {
            criteria.andPhoneLike(MybatisUtil.like(phone));
        }
        if (Objects.nonNull(from)) {
            criteria.andCreateTimeGreaterThanOrEqualTo(from);
        }
        if (Objects.nonNull(to)) {
            criteria.andCreateTimeLessThanOrEqualTo(to);
        }

        return repository.selectByExample(example);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String accept(Long userId, Task task) {

        DateTime now = DateTime.now();

        // 任务设置为进行中
        task.setStatus(TaskDef.TaskStatusEnum.Conducting.getCode());
        task.setUpdateTime(now);
        task.setAuxiliaryId(userId);

        super.update(task);

        // 领取任务
        UserTaskLink userTaskLink = new UserTaskLink();

        userTaskLink.setUserId(userId);
        userTaskLink.setTaskId(task.getId());
        userTaskLink.setStatus(TaskDef.TaskStatusEnum.Conducting.getCode());
        userTaskLink.setCreateTime(now);
        userTaskLink.setUpdateTime(now);

        userTaskLinkService.create(userTaskLink);

        return task.getQrcode();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Task create(Task task, User demander) {

        // 扣钱
        demander.setBalance(demander.getBalance().subtract(demander.getPrice()));

        userService.update(demander);

        return super.create(task);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long complateTask(Task task, UserTaskLink userTaskLink) {

        // 增加结算
        settlementService.increaseSettlement(userTaskLink.getUserId(), task.getDemanderId(), TaskDef.TaskStatusEnum.from(userTaskLink.getStatus()), SettlementDef.SettlementTypeEnum.Complete);

        task.setStatus(TaskDef.TaskStatusEnum.Completed.getCode());
        userTaskLink.setStatus(TaskDef.TaskStatusEnum.Completed.getCode());

        super.update(task);

        userTaskLinkService.create(userTaskLink);

        return task.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long userComplateTask(Task task, UserTaskLink userTaskLink) {
        task.setStatus(TaskDef.TaskStatusEnum.UserCompleted.getCode());
        userTaskLink.setStatus(TaskDef.TaskStatusEnum.UserCompleted.getCode());

        super.update(task);
        userTaskLinkService.update(userTaskLink);

        // 增加用户结算
        settlementService.increaseSettlement(userTaskLink.getUserId(), task.getDemanderId(), TaskDef.TaskStatusEnum.UserCompleted, SettlementDef.SettlementTypeEnum.UserComplete);

        return task.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Task> findWithPage(Long demanderId, String phone, Integer status, List<Long> demanderIds, List<Long> auxiliaryIds, DateTime from, DateTime to, PageRequest pageable) {

        TaskExample example = new TaskExample();

        TaskExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(demanderId)) {
            criteria.andDemanderIdEqualTo(demanderId);
        }
        if (StringUtils.isNotBlank(phone)) {
            criteria.andPhoneLike(MybatisUtil.like(phone));
        }
        if (Objects.nonNull(status)) {
            criteria.andStatusEqualTo(status);
        }
        if (!CollectionUtils.isEmpty(demanderIds)) {
            criteria.andDemanderIdIn(demanderIds);
        }
        if (!CollectionUtils.isEmpty(auxiliaryIds)) {
            criteria.andAuxiliaryIdIn(auxiliaryIds);
        }
        if (Objects.nonNull(from)) {
            criteria.andCreateTimeGreaterThanOrEqualTo(from);
        }
        if (Objects.nonNull(to)) {
            criteria.andCreateTimeLessThanOrEqualTo(to);
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
    private Page<Task> findByExampleWithPage(TaskExample example, PageRequest pageable) {

        int total = repository.countByExample(example);

        if (total == 0) {
            return Page.empty(pageable.getPage());
        }

        example.setOffset(pageable.getOffset());
        example.setLimit(pageable.getLimit());

        example.setOrderByClause("id desc");

        List<Task> tasks = repository.selectByExample(example);

        return Page.of(tasks, pageable.getPage(), total);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void taskExpire(Long taskId) {

        // 查找task
        Task task = super.findOne(taskId);

        if (Objects.isNull(task)) {
            log.error("未找到task: {}", taskId);
            return;
        }

        TaskDef.TaskStatusEnum status = TaskDef.TaskStatusEnum.from(task.getStatus());

        // 新建状态。表示没有人领取，直接过期
        if (status.equals(TaskDef.TaskStatusEnum.Enabled)) {
            task.setStatus(TaskDef.TaskStatusEnum.Expire.getCode());
            task.setUpdateTime(DateTime.now());

            addBalance(task);
            return;
        }

        // 暂停和冻结不处理

        // 进行中 -> 异常结束
        if (status.equals(TaskDef.TaskStatusEnum.Conducting)) {
            task.setStatus(TaskDef.TaskStatusEnum.Exception.getCode());
            task.setUpdateTime(DateTime.now());

            // 用户任务link表进行设置
            userTaskLinkService.findByTaskId(taskId).ifPresent(userTaskLink -> {
                userTaskLink.setStatus(TaskDef.TaskStatusEnum.Exception.getCode());
                userTaskLink.setUpdateTime(DateTime.now());
            });

            addBalance(task);

            this.update(task);
            return;
        }
    }

    private void addBalance(Task task) {
        // 用户的余额加回来
        User demander = userService.findOne(task.getDemanderId());

        demander.setBalance(demander.getBalance().add(task.getPrice()));

        userService.update(demander);
    }

}
