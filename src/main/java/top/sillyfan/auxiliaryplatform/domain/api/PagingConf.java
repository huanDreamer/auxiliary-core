package top.sillyfan.auxiliaryplatform.domain.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingConf {

    public final static Integer DefaultPage = 1;
    public final static Integer DefaultPageSize = 10;

    private Integer total;

    private Integer currentPage;

    /**
     * 创建 mongo 分页请求参数 按照创建时间降序排列
     *
     * @param page
     * @param pageSize
     * @return
     */
    public static PageRequest pageRequest(Optional<Integer> page, Optional<Integer> pageSize) {
        return PageRequest.of(page.orElse(DefaultPage) - 1, pageSize.orElse(DefaultPageSize), Sort.by(Sort.Order.desc("createTime")));
    }

    /**
     * 创建 mongo 分页请求参数 按照创建时间升序
     *
     * @param page
     * @param pageSize
     * @return
     */
    public static PageRequest pageRequestAsc(Optional<Integer> page, Optional<Integer> pageSize) {
        return PageRequest.of(page.orElse(DefaultPage) - 1, pageSize.orElse(DefaultPageSize), Sort.by(Sort.Order.asc("createTime")));
    }
}
