package top.sillyfan.auxiliaryplatform.domain.model;

import org.joda.time.DateTime;
import top.sillyfan.auxiliaryplatform.domain.model.extend.AccessMore;

public class Access extends AccessMore {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_access.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_access.demander_id
     *
     * @mbggenerated
     */
    private Long demanderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_access.auxiliary_id
     *
     * @mbggenerated
     */
    private Long auxiliaryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_access.mark
     *
     * @mbggenerated
     */
    private String mark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_access.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_access.create_time
     *
     * @mbggenerated
     */
    private DateTime createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_access.update_time
     *
     * @mbggenerated
     */
    private DateTime updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_access.id
     *
     * @return the value of t_access.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_access.id
     *
     * @param id the value for t_access.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_access.demander_id
     *
     * @return the value of t_access.demander_id
     *
     * @mbggenerated
     */
    public Long getDemanderId() {
        return demanderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_access.demander_id
     *
     * @param demanderId the value for t_access.demander_id
     *
     * @mbggenerated
     */
    public void setDemanderId(Long demanderId) {
        this.demanderId = demanderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_access.auxiliary_id
     *
     * @return the value of t_access.auxiliary_id
     *
     * @mbggenerated
     */
    public Long getAuxiliaryId() {
        return auxiliaryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_access.auxiliary_id
     *
     * @param auxiliaryId the value for t_access.auxiliary_id
     *
     * @mbggenerated
     */
    public void setAuxiliaryId(Long auxiliaryId) {
        this.auxiliaryId = auxiliaryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_access.mark
     *
     * @return the value of t_access.mark
     *
     * @mbggenerated
     */
    public String getMark() {
        return mark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_access.mark
     *
     * @param mark the value for t_access.mark
     *
     * @mbggenerated
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_access.status
     *
     * @return the value of t_access.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_access.status
     *
     * @param status the value for t_access.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_access.create_time
     *
     * @return the value of t_access.create_time
     *
     * @mbggenerated
     */
    public DateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_access.create_time
     *
     * @param createTime the value for t_access.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_access.update_time
     *
     * @return the value of t_access.update_time
     *
     * @mbggenerated
     */
    public DateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_access.update_time
     *
     * @param updateTime the value for t_access.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }
}