package top.sillyfan.auxiliaryplatform.constants;

public interface TaskDef {

    enum TaskStatusEnum {

        Valid(1, "有效"),
        Expire(10, "过期"),
        Refuse(20, "审核拒绝"),
        Exception(30, "异常"),
        Complete(40, "完成")
        ;

        private Integer code;
        private String name;

        TaskStatusEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
