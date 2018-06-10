package top.sillyfan.auxiliaryplatform.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface AccessDef {

    @Getter
    @AllArgsConstructor
    enum AccessStatusEnum {
        Access(1, "ok"),
        Init(10, "已发送"),
        Reject(40, "拒绝"),
        UnAccess(90, "未对接");        // 非DB值，用于筛选

        private Integer code;
        private String name;

        public Boolean match(final Integer code) {
            return this.code.equals(code);
        }
    }
}
