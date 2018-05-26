package top.sillyfan.auxiliaryplatform.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Task {

    @Id
    private String id;

    // 标题
    private String title;

    // qrcode解析的字符串
    private String qrcode;

    // 描述
    private String describe;

    // 需求方id
    private String demanderId;

    private String demanderName;

    // 价格 指的是客户需要出的价格
    private Float price;

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
}
