package top.sillyfan.auxiliaryplatform.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public interface UserDef {

    @AllArgsConstructor
    @Getter
    enum UserTypeEnum {

        Admin(1, "管理员", Arrays.asList(AuthorityName.ROLE_ADMIN)),
        Demander(2, "需求方", Arrays.asList(AuthorityName.ROLE_DEMANDER)),
        Super_auxiliary(3, "一级辅助方", Arrays.asList(AuthorityName.ROLE_SUPER_AUXILIARY, AuthorityName.ROLE_AUXILIARY)),
        Second_auxiliary(4, "二级辅助", Arrays.asList(AuthorityName.ROLE_SECOND_AUXILIARY, AuthorityName.ROLE_AUXILIARY)),
        Auxiliary(5, "辅助方", Arrays.asList(AuthorityName.ROLE_AUXILIARY)),;

        private Integer code;
        private String name;
        private List<String> auths;

        public boolean match(final Integer code) {
            return this.getCode().equals(code);
        }
    }


    @AllArgsConstructor
    @Getter
    enum UserStatusEnum {

        Enabled(1, "有效"),
        Disabled(10, "暂停"),
        Frozen(70, "被冻结"),
        Deleted(90, "已删除");

        private Integer code;
        private String name;

        static boolean isUserEnabled(final Integer code) {
            return Enabled.match(code);
        }

        public Boolean match(final Integer code) {
            return this.code.equals(code);
        }
    }

    @Getter
    @AllArgsConstructor
    enum OnlineEnum {
        Online(1, "在线"),
        Offline(10, "离线");

        private Integer code;
        private String name;

        static boolean isOnline(final Integer code) {
            return Online.match(code);
        }

        public Boolean match(final Integer code) {
            return this.code.equals(code);
        }
    }
}
