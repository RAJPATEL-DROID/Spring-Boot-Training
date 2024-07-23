package org.springdemo.multithreading.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdemo.multithreading.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GitHubUserService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubUserService.class);

    private final RestTemplate restTemplate;

    public GitHubUserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async("taskExecutor1")
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        logger.info("Looking up : {} " , user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

}
