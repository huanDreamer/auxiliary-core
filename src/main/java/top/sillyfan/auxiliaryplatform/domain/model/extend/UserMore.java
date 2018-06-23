package top.sillyfan.auxiliaryplatform.domain.model.extend;

import lombok.Data;
import top.sillyfan.auxiliaryplatform.domain.model.report.TaskReport;

@Data
public abstract class UserMore {

    /*一级辅助有的字段，表示他的下级用户数量*/
    private long secondNum;

    /*子账号个数 对于二级用户而言是底下的普通用户个数，对于一级用户而言，是底下二级和三级用户之和*/
    private long subNum;

    /*子账号有的字段，表示他上级用户名称*/
    private String superUserName;

    private TaskReport report;

    /*在用户中心返回已经用户列表时，需要显示用户和客户的对接关系*/
    private Integer accessStatus;
}
