package top.sillyfan.auxiliaryplatform.util;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import top.sillyfan.auxiliaryplatform.domain.model.JwtUser;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@Slf4j
public class PrincipalUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将principal中的权限信息解析出来
     *
     * @param principal
     * @return
     * @throws IOException
     */
    public static JwtUser extractUser(Principal principal) {

        Object details = ((OAuth2Authentication) principal).getUserAuthentication().getDetails();


        HashMap map = (HashMap) details;

        Object collect = ((ArrayList) (map.get("authorities"))).stream().map(m -> ((HashMap) m).get("authority")).map(Object::toString).collect(Collectors.toList());

        return JwtUser.builder()
                .id(Long.valueOf((Integer)map.get("id")))
                .username((String) map.get("username"))
                .email((String) map.get("email"))
                .type((Integer) map.get("type"))
                .superUser((Long) map.get("superUser"))
                .authorities((ArrayList) collect)
                .status((Integer) map.get("status")).build();
    }
}
