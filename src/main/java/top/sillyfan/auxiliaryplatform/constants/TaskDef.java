package top.sillyfan.auxiliaryplatform.constants;

import lombok.Getter;

import java.util.Objects;

public interface TaskDef {

    @Getter
    enum TaskStatusEnum {

        Unknown(0, "未知"),
        Enabled(1, "有效"),
        Disabled(10, "暂停"),
        Expire(20, "过期"),
        Exception(30, "异常结束"), // 用户领取任务之后没有完成
        Conducting(40, "进行中"),
        Completed(50, "完成"),
        Frozen(70, "被冻结"),
        Deleted(90, "删除");

        private Integer code;
        private String name;

        TaskStatusEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public static TaskStatusEnum from(Integer code) {
            if (Objects.isNull(code)) {
                return Unknown;
            }
            for (TaskStatusEnum status : TaskStatusEnum.values()) {
                if (status.match(code)) {
                    return status;
                }
            }
            return Unknown;
        }

        public Boolean match(final Integer code) {
            return this.code.equals(code);
        }
    }
}
