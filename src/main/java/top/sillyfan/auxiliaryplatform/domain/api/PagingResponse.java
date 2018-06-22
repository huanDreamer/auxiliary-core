package top.sillyfan.auxiliaryplatform.domain.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.sillyfan.auxiliaryplatform.domain.api.page.Page;

import java.util.List;


@Data
@AllArgsConstructor
public class PagingResponse<T> {

    private List<T> data;

    private PagingConf pagingConf;

    public PagingResponse(Page<T> data) {
        this.data = data.getElements();
        this.pagingConf = new PagingConf(data.getTotal(), data.getPage());
    }
}
