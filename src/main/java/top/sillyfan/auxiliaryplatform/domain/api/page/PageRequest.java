package top.sillyfan.auxiliaryplatform.domain.api.page;

import lombok.Data;
import lombok.NonNull;

@Data
public class PageRequest {

    @NonNull
    private Integer offset;

    @NonNull
    private Integer limit;

    @NonNull
    private Integer page;

    public static PageRequest of(Integer page, Integer pageSize) {
        return new PageRequest(pageSize * (page - 1), pageSize, page);
    }
}
