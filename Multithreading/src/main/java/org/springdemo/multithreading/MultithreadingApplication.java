package org.springdemo.multithreading;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
@EnableCaching
public class MultithreadingApplication {

    public static void main(String[] args) {

        SpringApplication.run(MultithreadingApplication.class, args);
    }

    @Bean
    @Qualifier("taskExecutor1")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(5);
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        threadPoolTaskExecutor.setQueueCapacity(20);
        threadPoolTaskExecutor.setThreadNamePrefix("Github-API-Thread");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean
    @Primary
    public Executor taskExecutor2(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(2);
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(false);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setThreadNamePrefix("Github-API-Thread-2");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

}
