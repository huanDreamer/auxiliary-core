package top.sillyfan.auxiliaryplatform.domain.api.page;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Data
@Builder
public class Page<T> {

    private List<T> elements;

    private Integer total;

    private Integer page;

    public static <T> Page<T> empty(Integer page) {
        return (Page<T>) Page.builder().elements(Collections.emptyList()).total(0).page(page).build();
    }

    public static <T> Page<T> of(List<T> elements, Integer page, Integer total) {
        return Page.<T>builder().elements(elements).page(page).total(total).build();
    }

    public boolean hasContent() {
        return CollectionUtils.isNotEmpty(elements);
    }
}
