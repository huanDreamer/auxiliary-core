package top.sillyfan.auxiliaryplatform.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import top.sillyfan.auxiliaryplatform.domain.model.extend.AccessMore;

/**
 * 接入记录
 */
@Builder
@Data
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Access extends AccessMore {

    @Id
    private String id;

    private String demanderId;

    private String auxiliaryId;

    private String mark;

    private Integer status;

    private DateTime createTime;

    private DateTime updateTime;

}
