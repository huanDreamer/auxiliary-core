package top.sillyfan.auxiliaryplatform.domain.model;

import org.joda.time.DateTime;
import top.sillyfan.auxiliaryplatform.domain.model.extend.UserTaskMore;

public class UserTaskLink extends UserTaskMore {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_task_link.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_task_link.task_id
     *
     * @mbggenerated
     */
    private Long taskId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_task_link.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_task_link.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_task_link.create_time
     *
     * @mbggenerated
     */
    private DateTime createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_task_link.update_time
     *
     * @mbggenerated
     */
    private DateTime updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_task_link.id
     *
     * @return the value of t_user_task_link.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_task_link.id
     *
     * @param id the value for t_user_task_link.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_task_link.task_id
     *
     * @return the value of t_user_task_link.task_id
     *
     * @mbggenerated
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_task_link.task_id
     *
     * @param taskId the value for t_user_task_link.task_id
     *
     * @mbggenerated
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_task_link.user_id
     *
     * @return the value of t_user_task_link.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_task_link.user_id
     *
     * @param userId the value for t_user_task_link.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_task_link.status
     *
     * @return the value of t_user_task_link.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_task_link.status
     *
     * @param status the value for t_user_task_link.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_task_link.create_time
     *
     * @return the value of t_user_task_link.create_time
     *
     * @mbggenerated
     */
    public DateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_task_link.create_time
     *
     * @param createTime the value for t_user_task_link.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_task_link.update_time
     *
     * @return the value of t_user_task_link.update_time
     *
     * @mbggenerated
     */
    public DateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_task_link.update_time
     *
     * @param updateTime the value for t_user_task_link.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }
}