package top.sillyfan.auxiliaryplatform.util;

import java.util.UUID;

public class IdUtil {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
