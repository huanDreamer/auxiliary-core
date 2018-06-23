package top.sillyfan.auxiliaryplatform.domain.model.json;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class LongSet extends HashSet<Long> {
    public static LongSet of(Long... str) {
        LongSet list = new LongSet();

        list.addAll(Arrays.asList(str));

        return list;
    }

    public static LongSet of(Collection<Long> list) {

        LongSet strings = new LongSet();

        if (CollectionUtils.isNotEmpty(list)) {
            strings.addAll(list);
        }

        return strings;
    }
}
