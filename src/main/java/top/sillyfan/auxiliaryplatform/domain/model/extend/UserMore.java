package top.sillyfan.auxiliaryplatform.domain.model.extend;

import lombok.Data;

@Data
public abstract class UserMore {

    /*一级辅助有的字段，表示他的下级用户数量*/
    private long subNum;

    /*二级辅助有的字段，表示他上级用户名称*/
    private String superUserName;
}
