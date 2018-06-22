package top.sillyfan.auxiliaryplatform.domain.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.sillyfan.auxiliaryplatform.domain.api.page.PageRequest;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingConf {

    public final static Integer DefaultPage = 1;
    public final static Integer DefaultPageSize = 10;

    private Integer total;

    private Integer currentPage;

    public static PageRequest pageRequest(Optional<Integer> page, Optional<Integer> pageSize) {
        return PageRequest.of(page.orElse(DefaultPage) - 1, pageSize.orElse(DefaultPageSize));
    }
}
