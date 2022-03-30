package ShopAppJwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean("OKHttp3")
    public RestTemplate OKHttp3RestTemplate(){
        // 替換 RestTemplate 底層 效率較好 (要導入OkHttp包)
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
