package top.sillyfan.auxiliaryplatform.domain.api.page;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Builder
public class Page<T> {

    private List<T> elements;

    private Integer total;

    private Integer page;

    public static <T> Page<T> empty(Integer page) {
        return (Page<T>)Page.builder().elements(Collections.emptyList()).total(0).page(page).build();
    }
}
