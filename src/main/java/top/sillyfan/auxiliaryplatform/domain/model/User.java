package top.sillyfan.auxiliaryplatform.domain.model;

import java.math.BigDecimal;
import org.joda.time.DateTime;
import top.sillyfan.auxiliaryplatform.domain.model.extend.UserMore;
import top.sillyfan.auxiliaryplatform.domain.model.json.StringList;

public class User extends UserMore {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.super_user
     *
     * @mbggenerated
     */
    private Long superUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.qq
     *
     * @mbggenerated
     */
    private String qq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.max_token_num
     *
     * @mbggenerated
     */
    private Integer maxTokenNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.max_thread_num
     *
     * @mbggenerated
     */
    private Integer maxThreadNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.online
     *
     * @mbggenerated
     */
    private Integer online;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.price
     *
     * @mbggenerated
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.balance
     *
     * @mbggenerated
     */
    private BigDecimal balance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.authorizes
     *
     * @mbggenerated
     */
    private StringList authorizes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.task_status
     *
     * @mbggenerated
     */
    private Integer taskStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.last_password_reset_date
     *
     * @mbggenerated
     */
    private DateTime lastPasswordResetDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.mark
     *
     * @mbggenerated
     */
    private String mark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.old_id
     *
     * @mbggenerated
     */
    private String oldId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.expire_date
     *
     * @mbggenerated
     */
    private DateTime expireDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.super_user
     *
     * @return the value of t_user.super_user
     *
     * @mbggenerated
     */
    public Long getSuperUser() {
        return superUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.super_user
     *
     * @param superUser the value for t_user.super_user
     *
     * @mbggenerated
     */
    public void setSuperUser(Long superUser) {
        this.superUser = superUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.username
     *
     * @return the value of t_user.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.username
     *
     * @param username the value for t_user.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.email
     *
     * @return the value of t_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.email
     *
     * @param email the value for t_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.qq
     *
     * @return the value of t_user.qq
     *
     * @mbggenerated
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.qq
     *
     * @param qq the value for t_user.qq
     *
     * @mbggenerated
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.phone
     *
     * @return the value of t_user.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.phone
     *
     * @param phone the value for t_user.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.type
     *
     * @return the value of t_user.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.type
     *
     * @param type the value for t_user.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.max_token_num
     *
     * @return the value of t_user.max_token_num
     *
     * @mbggenerated
     */
    public Integer getMaxTokenNum() {
        return maxTokenNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.max_token_num
     *
     * @param maxTokenNum the value for t_user.max_token_num
     *
     * @mbggenerated
     */
    public void setMaxTokenNum(Integer maxTokenNum) {
        this.maxTokenNum = maxTokenNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.max_thread_num
     *
     * @return the value of t_user.max_thread_num
     *
     * @mbggenerated
     */
    public Integer getMaxThreadNum() {
        return maxThreadNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.max_thread_num
     *
     * @param maxThreadNum the value for t_user.max_thread_num
     *
     * @mbggenerated
     */
    public void setMaxThreadNum(Integer maxThreadNum) {
        this.maxThreadNum = maxThreadNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.online
     *
     * @return the value of t_user.online
     *
     * @mbggenerated
     */
    public Integer getOnline() {
        return online;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.online
     *
     * @param online the value for t_user.online
     *
     * @mbggenerated
     */
    public void setOnline(Integer online) {
        this.online = online;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.price
     *
     * @return the value of t_user.price
     *
     * @mbggenerated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.price
     *
     * @param price the value for t_user.price
     *
     * @mbggenerated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.balance
     *
     * @return the value of t_user.balance
     *
     * @mbggenerated
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.balance
     *
     * @param balance the value for t_user.balance
     *
     * @mbggenerated
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.authorizes
     *
     * @return the value of t_user.authorizes
     *
     * @mbggenerated
     */
    public StringList getAuthorizes() {
        return authorizes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.authorizes
     *
     * @param authorizes the value for t_user.authorizes
     *
     * @mbggenerated
     */
    public void setAuthorizes(StringList authorizes) {
        this.authorizes = authorizes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.status
     *
     * @return the value of t_user.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.status
     *
     * @param status the value for t_user.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.task_status
     *
     * @return the value of t_user.task_status
     *
     * @mbggenerated
     */
    public Integer getTaskStatus() {
        return taskStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.task_status
     *
     * @param taskStatus the value for t_user.task_status
     *
     * @mbggenerated
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.last_password_reset_date
     *
     * @return the value of t_user.last_password_reset_date
     *
     * @mbggenerated
     */
    public DateTime getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.last_password_reset_date
     *
     * @param lastPasswordResetDate the value for t_user.last_password_reset_date
     *
     * @mbggenerated
     */
    public void setLastPasswordResetDate(DateTime lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.mark
     *
     * @return the value of t_user.mark
     *
     * @mbggenerated
     */
    public String getMark() {
        return mark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.mark
     *
     * @param mark the value for t_user.mark
     *
     * @mbggenerated
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.old_id
     *
     * @return the value of t_user.old_id
     *
     * @mbggenerated
     */
    public String getOldId() {
        return oldId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.old_id
     *
     * @param oldId the value for t_user.old_id
     *
     * @mbggenerated
     */
    public void setOldId(String oldId) {
        this.oldId = oldId == null ? null : oldId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.expire_date
     *
     * @return the value of t_user.expire_date
     *
     * @mbggenerated
     */
    public DateTime getExpireDate() {
        return expireDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.expire_date
     *
     * @param expireDate the value for t_user.expire_date
     *
     * @mbggenerated
     */
    public void setExpireDate(DateTime expireDate) {
        this.expireDate = expireDate;
    }
}