package top.sillyfan.auxiliaryplatform.constants;

import lombok.Getter;

public interface TaskDef {

    @Getter
    enum TaskStatusEnum {

        Valid(1, "有效"),
        Expire(10, "过期"),
        Refuse(20, "审核拒绝"),
        Exception(30, "异常"),
        Conducting(40, "进行中"),
        Complete(50, "完成");

        private Integer code;
        private String name;

        TaskStatusEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }
}
