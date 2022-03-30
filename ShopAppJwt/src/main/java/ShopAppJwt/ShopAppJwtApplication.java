package ShopAppJwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableCaching
@EnableJpaAuditing
@SpringBootApplication
public class ShopAppJwtApplication {

    public static void main(String[] args) {

//      下面語句使得Log4j2日誌輸出使用異步處理，減小輸出日誌對性能的影響
        System.setProperty("Log4jContextSelector",
                "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");

        SpringApplication.run(ShopAppJwtApplication.class, args);
    }

}