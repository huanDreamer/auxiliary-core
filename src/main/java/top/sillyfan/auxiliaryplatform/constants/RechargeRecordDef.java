package top.sillyfan.auxiliaryplatform.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface RechargeRecordDef {

    @Getter
    @AllArgsConstructor
    enum RechargeRecordTypeEnum {
        EditBalance(1, "直接修改余额"),
        SelfCharge(2, "自助充值"),

        ;
        private Integer code;
        private String name;

        public Boolean match(final Integer code) {
            return this.code.equals(code);
        }
    }
}
