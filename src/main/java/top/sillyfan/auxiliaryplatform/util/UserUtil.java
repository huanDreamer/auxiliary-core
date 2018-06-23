package top.sillyfan.auxiliaryplatform.util;

import top.sillyfan.auxiliaryplatform.domain.model.User;

/**
 * 用户工具类
 */
public class UserUtil {


    /**
     * 清洗用户数据，只返回基本信息
     *
     * @param user
     * @return
     */
    public static User cleanInfo(User user) {

        user.setPassword(null);

//        User u = new User();
//
//        u.setId(user.getId());
//        u.setEmail(user.getEmail());
//        u.setUsername(user.getUsername());
//        u.setQq(user.getQq());
//        u.setMark(user.getMark());
//        u.setPhone(user.getPhone());
//        u.setMaxTokenNum(user.getMaxTokenNum());
//        u.setTaskStatus(user.getTaskStatus());
//        u.setOnline(user.getOnline());

        return user;
    }
}
