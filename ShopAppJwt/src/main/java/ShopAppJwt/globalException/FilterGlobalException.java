package ShopAppJwt.globalException;

import ShopAppJwt.mapper.ResponseMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
public class FilterGlobalException implements Filter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean isRethrow = !Objects.isNull(servletRequest.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
        if(isRethrow){ // 是否早就有異常 避免 filter loop error
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        try{
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            servletResponse.setContentType("application/json;charset=utf-8");
            servletResponse.setCharacterEncoding("UTF-8");
            objectMapper.writeValue(
                    servletResponse.getOutputStream(),
                    ResponseMapper.error(ExceptionType.SYSTEM_ERROR,
                            "Internal Server Error ， Please Try Again Later !"));
            log.warn(Arrays.toString(e.getStackTrace()) +
                    e.getClass() +
                    e.getMessage() +
                    " ======== FilterGlobalException ========");
        }
    }

    @Override
    public void destroy() {}
}
