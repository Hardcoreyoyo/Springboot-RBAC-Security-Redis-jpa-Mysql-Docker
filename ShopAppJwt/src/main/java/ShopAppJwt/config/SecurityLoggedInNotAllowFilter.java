package ShopAppJwt.config;

import ShopAppJwt.controller.PathUtils;
import ShopAppJwt.globalException.ExceptionType;
import ShopAppJwt.mapper.ResponseMapper;
import ShopAppJwt.service.JWT.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class SecurityLoggedInNotAllowFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    PathMatcher pathMatcher;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader(jwtTokenUtil.getHeader());

        if (!JwtUrlvalidattion(jwtToken, request)) {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            objectMapper.writeValue(
                    response.getOutputStream(),
                    ResponseMapper.error(
                            ExceptionType.USER_INPUT_ERROR,
                            "Request is Not Allowed !"));
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private boolean JwtUrlvalidattion(String jwtToken, HttpServletRequest request) {
        String getRequestUrl = request.getRequestURI();
        boolean jwtTokenNull = jwtToken == null;
        boolean AuthPost = Objects.equals(request.getMethod(), "POST");
        boolean AuthGet = Objects.equals(request.getMethod(), "GET");
        for (String url : PathUtils.LOGGED_IN_NOT_ALLOW) {
            boolean AuthUrl = pathMatcher.match(url, getRequestUrl);
            boolean NullAndUrl = !jwtTokenNull && AuthUrl;
            if (NullAndUrl && AuthPost) {
                return false;
            }
            if (NullAndUrl && AuthGet) {
                return false;
            }
        }
        return true;
    }
}