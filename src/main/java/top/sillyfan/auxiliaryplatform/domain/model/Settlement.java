package top.sillyfan.auxiliaryplatform.domain.model;

import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import top.sillyfan.auxiliaryplatform.domain.model.extend.SettlementMore;
import top.sillyfan.auxiliaryplatform.util.IdUtil;

/**
 * 结算清单，针对于用户来说，每个用户对于每个客户都对应有结算资料
 */
@Builder
@Data
@Document
public class Settlement extends SettlementMore {

    @Id
    private String id;

    // 用户id
    private String auxiliaryId;

    // 客户id
    private String demanderId;

    // 完成数
    private Integer complete;

    // 用户完成数
    private Integer userComplete;

    // 数据更新时间
    private DateTime updateTime;

    @Transient
    public static Settlement build(String auxiliaryId, String demanderId) {
        return Settlement.builder()
                .id(IdUtil.generateId())
                .auxiliaryId(auxiliaryId)
                .demanderId(demanderId)
                .complete(0)
                .userComplete(0)
                .updateTime(DateTime.now()).build();

    }

}
