package top.sillyfan.auxiliaryplatform.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import top.sillyfan.auxiliaryplatform.domain.model.extend.TaskMore;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Task extends TaskMore {

    @Id
    private String id;

    // 标题
    private String title;

    // qrcode解析的字符串
    private String qrcode;

    // 描述
    private String describe;

    // 任务的电话号码
    private String phone;

    @JsonIgnore
    private BigDecimal price;

    // 需求方id
    private String demanderId;

    // 领取者id
    private String auxiliaryId;

    // 状态
    private Integer status;

    // 状态说明
    private String statusDesc;

    // 有效时间 单位：秒
    private Integer expire;

    // 生成时间
    private DateTime createTime;

    // 更新时间
    private DateTime updateTime;

    @JsonIgnore
    public Boolean isExpired() {
        return DateTime.now().isAfter(createTime.plusSeconds(Objects.isNull(expire) ? 0 : expire));
    }
}
