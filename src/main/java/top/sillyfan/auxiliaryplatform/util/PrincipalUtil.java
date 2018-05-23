package top.sillyfan.auxiliaryplatform.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import top.sillyfan.auxiliaryplatform.domain.model.JwtUser;

import java.io.IOException;
import java.security.Principal;

public class PrincipalUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JwtUser extractUser(Principal principal) throws IOException {

        Object details = ((OAuth2Authentication) principal).getUserAuthentication().getDetails();


        JwtUser jwtUser = objectMapper.readValue(objectMapper.writeValueAsString(details), JwtUser.class);

        return null;
    }
}
