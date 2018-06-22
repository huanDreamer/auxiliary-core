package top.sillyfan.auxiliaryplatform.util;

public class MybatisUtil {

    public static String like(String query) {
        return "%" + query + "%";
    }
}
