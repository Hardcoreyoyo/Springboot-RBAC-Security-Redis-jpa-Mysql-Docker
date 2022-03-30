package ShopAppJwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.List;

@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration config = new CorsConfiguration();
        //開放哪些ip、端口、域名的訪問權限，星號表示開放所有域
        config.addAllowedOrigin("*");
        //是否允許發送Cookie信息
        config.setAllowCredentials(true);
        //開放哪些Http方法，允許跨域訪問
        config.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE"));
        //request 允許HTTP請求中的攜帶哪些Header信息
        config.addAllowedHeader("*");
        //response 暴露哪些頭部信息（因為跨域訪問默認不能獲取全部頭部信息）
        config.addExposedHeader("Location");
        config.addExposedHeader("JWTHeaderName");

        //添加映射路徑，“/**”表示對所有的路徑實行全局跨域訪問權限的設置
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }
}
