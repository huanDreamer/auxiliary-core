package top.sillyfan.auxiliaryplatform.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import top.sillyfan.auxiliaryplatform.domain.model.JwtUser;

import java.io.IOException;
import java.security.Principal;

public class PrincipalUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将principal中的权限信息解析出来
     *
     * @param principal
     * @return
     * @throws IOException
     */
    public static JwtUser extractUser(Principal principal) throws IOException {

        Object details = ((OAuth2Authentication) principal).getUserAuthentication().getDetails();

        // TODO user的authoprizes为乱的
        JwtUser jwtUser = objectMapper.readValue(objectMapper.writeValueAsString(details), JwtUser.class);

        return jwtUser;
    }
}
