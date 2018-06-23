package top.sillyfan.auxiliaryplatform.util;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListUtil {

    public static <T> List<T> of(Collection<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return new ArrayList<>(list);
    }
}
