package ShopAppJwt.globalException;

import ShopAppJwt.mapper.ResponseMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(path = "/error")
public class ExceptionController implements ErrorController {

    // TODO: When You Already Coding Global Exception Handling...
    //       In Spring Security，
    //       Request part of AntMatch Url after Authorization successful，
    //       It will handling by spring ErrorController without Exception，
    //       Ex: AntMatch("/member") ， Requset: /member/xxxxx。

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping
    public void error(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        objectMapper.writeValue(
                response.getOutputStream(),
                ResponseMapper.error(ExceptionType.USER_INPUT_ERROR,
                        "Not Found， Please Try Again Later !"));
    }
}
