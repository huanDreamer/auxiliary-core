package top.sillyfan.auxiliaryplatform.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private String code;

    private T data;

    private String message;

    public ApiResponse(ApiResponseCode code) {
        this(code, null);
    }

    public ApiResponse(ApiResponseCode code, T data) {
        this.data = data;
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public static ApiResponse success() {
        return new ApiResponse(ApiResponseCode.Api_0);
    }

    public static <T> ApiResponse success(T data) {
        return new ApiResponse(ApiResponseCode.Api_0, data);
    }
}
