package top.sillyfan.auxiliaryplatform.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private String code;

    private T data;

    private String massage;

    public ApiResponse(ApiResponseCode code) {
        this(code, null);
    }

    public ApiResponse(ApiResponseCode code, T data) {
        this.data = data;
        this.code = code.getCode();
        this.massage = code.getMessage();
    }

    public static ApiResponse success() {
        return new ApiResponse(ApiResponseCode.Api_0);
    }

    public static <T> ApiResponse success(T data) {
        return new ApiResponse(ApiResponseCode.Api_0, data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
