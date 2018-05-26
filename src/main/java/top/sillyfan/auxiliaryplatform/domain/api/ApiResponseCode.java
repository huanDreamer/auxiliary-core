package top.sillyfan.auxiliaryplatform.domain.api;

import org.springframework.util.Assert;

public enum ApiResponseCode {

    Api_0(ApiResponseCodeDef.Api_0, "成功"),
    Api_1001(ApiResponseCodeDef.Api_1001, "用户已存在")

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
