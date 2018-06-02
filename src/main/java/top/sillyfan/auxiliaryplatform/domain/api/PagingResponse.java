package top.sillyfan.auxiliaryplatform.domain.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;


@Data
@AllArgsConstructor
public class PagingResponse<T> {

    private List<T> data;

    private PagingConf pagingConf;

    public PagingResponse(Page<T> data) {
        this.data = data.getContent();
        this.pagingConf = new PagingConf((int) data.getTotalElements(), data.getPageable().getPageNumber());
    }
}
