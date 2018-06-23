package top.sillyfan.auxiliaryplatform.domain.model.json;


import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class StringList extends ArrayList<String> {

    public static StringList of(String... str) {
        StringList strings = new StringList();

        strings.addAll(Arrays.asList(str));

        return strings;
    }

    public static StringList of(Collection<String> list) {
        StringList strings = new StringList();

        if (CollectionUtils.isNotEmpty(list)) {
            strings.addAll(list);
        }

        return strings;
    }

}
