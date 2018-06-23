package top.sillyfan.auxiliaryplatform.domain.api.page;

import lombok.Data;
import lombok.NonNull;

import java.util.Optional;

@Data
public class PageRequest {

    public final static Integer DefaultPage = 1;
    public final static Integer DefaultPageSize = 10;

    @NonNull
    private Integer offset;

    @NonNull
    private Integer limit;

    @NonNull
    private Integer page;

    public static PageRequest of(Optional<Integer> page, Optional<Integer> pageSize) {
        Integer _page = page.orElse(DefaultPage);
        Integer _pageSize = pageSize.orElse(DefaultPageSize);
        return new PageRequest(_pageSize * (_page - 1), _pageSize, _page);
    }
}
