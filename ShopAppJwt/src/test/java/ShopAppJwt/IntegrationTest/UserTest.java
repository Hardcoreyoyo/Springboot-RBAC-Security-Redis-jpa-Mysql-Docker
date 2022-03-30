package ShopAppJwt.IntegrationTest;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void Login() throws Exception {

        // TODO 無法將方法返回的值，付值給全域變數，讓其他方法使用，故先將各個方法都寫在一起

        System.out.println("================ Login ================");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/a")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content("{\n" +
                        "  \"username\":\"user1\",\n" +
                        "  \"password\":\"12345\"\n" +
                        "}");

        MvcResult mvcResult
                = mockMvc.perform(requestBuilder)
                         .andExpect(status().is(200))
                         .andExpect(jsonPath("$.message", equalTo("success")))
                         .andDo(print())
                         .andReturn();

        String res = mvcResult.getResponse().getContentAsString();
        String TEST_TOKEN = JsonPath.parse(res).read("$.data");

        System.out.println("================ NoJosnContent ================");

        // TODO: Test console 亂碼時解決寫法
        ResultActions noJosnContent = mockMvc.perform(
                MockMvcRequestBuilders.post("/a")
                                      .characterEncoding("UTF-8")
                                      .contentType(MediaType.APPLICATION_JSON));
        noJosnContent
                .andReturn()
                .getResponse()
                .setCharacterEncoding("UTF-8");
        noJosnContent
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.code", equalTo(400)))
                .andDo(print());

        System.out.println("================ HasToken ================");

        RequestBuilder HasToken = MockMvcRequestBuilders
                .get("/member")
                .characterEncoding("UTF-8")
                .header("JWTHeaderName",TEST_TOKEN);

        mockMvc.perform(HasToken)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.message", equalTo("success")))
                .andDo(print());

        System.out.println("================ NoToken ================");

        RequestBuilder NoToken = MockMvcRequestBuilders
                .get("/member")
                .characterEncoding("UTF-8");

        mockMvc.perform(NoToken)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.code", equalTo(400)))
                .andDo(print());
    }
}
