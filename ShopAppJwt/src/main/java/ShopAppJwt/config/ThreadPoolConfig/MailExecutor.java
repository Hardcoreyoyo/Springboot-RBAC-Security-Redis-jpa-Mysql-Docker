package ShopAppJwt.config.ThreadPoolConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class MailExecutor {

    //TODO: Dont use the same pool for each Services

    @Bean("SendMailExecutor")
    public Executor taskExecutorA() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心線程數量：當前機器的核心數
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        // 最大線程數
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2 + 4);
        // 隊列大小
        executor.setQueueCapacity(Runtime.getRuntime().availableProcessors() * 2);
        // 線程最大空閒時間
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("SendMailExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setAwaitTerminationSeconds(60);
        return executor;
    }
}
