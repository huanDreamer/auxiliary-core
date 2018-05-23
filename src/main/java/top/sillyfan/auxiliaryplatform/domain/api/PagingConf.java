package top.sillyfan.auxiliaryplatform.domain.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PagingConf {

    public final static Integer page = 1;
    public final static Integer pageSize = 20;

    private Integer total;
}
