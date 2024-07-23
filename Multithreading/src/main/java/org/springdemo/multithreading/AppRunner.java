package org.springdemo.multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdemo.multithreading.model.User;
import org.springdemo.multithreading.repository.BookRepository;
import org.springdemo.multithreading.service.GitHubUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
    private final GitHubUserService gitHubUserService;
    private final BookRepository bookRepository;

    public AppRunner(GitHubUserService gitHubUserService, BookRepository bookRepository) {
        this.gitHubUserService = gitHubUserService;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
//        long start = System.currentTimeMillis();
//
//        CompletableFuture<User> page1 = gitHubUserService.findUser("rajpatel-droid");
//
//        CompletableFuture<User> page2 = gitHubUserService.findUser("ShivamPansuriya");
//
//        CompletableFuture.allOf(page1,page2).join();
//
//        logger.info("Elapsed Time : {}"  ,(System.currentTimeMillis()- start));
//        logger.info("--> {}", page1.get());
//        logger.info("--> {}" , page2.get());

        logger.info("......Fetching Books By Author........");
        logger.info("author : Karl Max --> {}", bookRepository.getByAuthor("Karl Max"));
        logger.info("author : Socrates --> {}", bookRepository.getByAuthor("Socrates"));

        // Now we have both books cached ,following will be quried very quickly
        logger.info("author : Karl Max --> {}", bookRepository.getByAuthor("Karl Max"));
        logger.info("author : Karl Max --> {}", bookRepository.getByAuthor("Karl Max"));
        logger.info("author : Socrates --> {}", bookRepository.getByAuthor("Socrates"));
        logger.info("author : Socrates --> {}", bookRepository.getByAuthor("Socrates"));

    }
}
