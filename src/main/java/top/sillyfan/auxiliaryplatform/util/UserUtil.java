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

        return User.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .qq(user.getQq())
                .mark(user.getMark())
                .phone(user.getPhone())
                .build();
    }
}
