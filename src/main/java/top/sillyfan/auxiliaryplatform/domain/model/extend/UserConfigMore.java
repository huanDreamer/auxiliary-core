package top.sillyfan.auxiliaryplatform.domain.model.extend;

import top.sillyfan.auxiliaryplatform.domain.model.UserConfig;

public class UserConfigMore {

    public static UserConfig buildDefault(Long userId) {
        UserConfig userConfig = new UserConfig();
        userConfig.setUserId(userId);
        return userConfig;
    }
}
