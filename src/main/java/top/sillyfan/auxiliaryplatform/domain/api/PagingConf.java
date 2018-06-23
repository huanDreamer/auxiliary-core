package top.sillyfan.auxiliaryplatform.domain.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingConf {

    public final static Integer DefaultPage = 1;
    public final static Integer DefaultPageSize = 10;

    private Integer total;

    private Integer currentPage;

}
