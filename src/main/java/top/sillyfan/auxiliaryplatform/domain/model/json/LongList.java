package top.sillyfan.auxiliaryplatform.domain.model.json;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class LongList extends ArrayList<Long> {

    public static LongList of(Long... str) {
        LongList list = new LongList();

        list.addAll(Arrays.asList(str));

        return list;
    }

    public static LongList of(Collection<Long> list) {
        LongList strings = new LongList();

        if (CollectionUtils.isNotEmpty(list)) {
            strings.addAll(list);
        }

        return strings;
    }
}
