package ShopAppJwt.globalException;

import ShopAppJwt.mapper.ResponseMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@Component
public class SecurityAnonymousAccessDeniedException implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        objectMapper.writeValue(
                httpServletResponse.getOutputStream(),
                ResponseMapper.error(ExceptionType.USER_INPUT_ERROR,
                        "Access Denied ， Please Try Again Later !"));
        log.warn(Arrays.toString(e.getStackTrace()) +
                e.getClass() +
                e.getMessage() +
                " Anonymous Access Denied ， Please Try Again Later !");

    }
}
