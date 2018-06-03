package top.sillyfan.auxiliaryplatform.domain.api;

import org.springframework.util.Assert;

public enum ApiResponseCode {

    Api_0(ApiResponseCodeDef.Api_0, "成功"),
    Api_1001(ApiResponseCodeDef.Api_1001, "用户已存在"),
    Api_1002(ApiResponseCodeDef.Api_1002, "您没有权限进行此操作"),
    Api_1003(ApiResponseCodeDef.Api_1003, "任务已被领取"),
    Api_1004(ApiResponseCodeDef.Api_1004, "任务已过期"),
    Api_1005(ApiResponseCodeDef.Api_1005, "任务未找到"),
    Api_1006(ApiResponseCodeDef.Api_1006, "客户未找到"),
    Api_1007(ApiResponseCodeDef.Api_1007, "余额不足，请尽快充值"),
    Api_1008(ApiResponseCodeDef.Api_1008, "未识别到二维码"),
    Api_1009(ApiResponseCodeDef.Api_1009, "用户未找到"),
    ;

    private String code;

    private String message;

    ApiResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiResponseCode from(String c) {
        Assert.notNull(c, "code不能为null");
        for (ApiResponseCode code :
                ApiResponseCode.values()) {
            if (code.getCode().equals(c)) {
                return code;
            }
        }
        throw new IllegalArgumentException("未找到api Response Code" + c);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
