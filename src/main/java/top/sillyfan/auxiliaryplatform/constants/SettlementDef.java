package top.sillyfan.auxiliaryplatform.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface SettlementDef {

    @Getter
    @AllArgsConstructor
    enum SettlementTypeEnum {

        Complete(1, "完成"),
        UserComplete(2, "用户完成");

        private Integer code;
        private String name;

        public Boolean match(final Integer code) {
            return this.code.equals(code);
        }
    }
}
