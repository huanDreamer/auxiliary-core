package top.sillyfan.auxiliaryplatform.constants;

import java.util.Arrays;
import java.util.List;

public interface UserDef {

    enum UserTypeEnum {

        Admin(1, "管理员", Arrays.asList(AuthorityName.ROLE_ADMIN)),
        Demander(2, "需求方", Arrays.asList(AuthorityName.ROLE_DEMANDER)),
        User(3, "用户", Arrays.asList(AuthorityName.ROLE_USER))

        ;

        private Integer code;
        private String name;
        private List<String> auths;

        UserTypeEnum(Integer code, String name, List<String> auths) {
            this.code = code;
            this.name = name;
            this.auths = auths;
        }

        public Boolean match(final Integer code) {
            return this.code.equals(code);
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getAuths() {
            return auths;
        }

        public void setAuths(List<String> auths) {
            this.auths = auths;
        }
    }
}
