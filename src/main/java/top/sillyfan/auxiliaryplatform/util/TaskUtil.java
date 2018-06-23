package top.sillyfan.auxiliaryplatform.util;

import org.joda.time.DateTime;
import top.sillyfan.auxiliaryplatform.domain.model.Task;

import java.util.Objects;

public class TaskUtil {

    public static Boolean isExpired(Task task) {
        return DateTime.now().isAfter(task.getCreateTime().plusSeconds(Objects.isNull(task.getExpire()) ? 0 : task.getExpire()));
    }
}
