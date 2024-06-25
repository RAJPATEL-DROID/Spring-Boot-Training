package com.restapi.restwithspring.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class userDetailsCommnadLineRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(getClass());

    private UserDetailsRepository userDetailsRepository;

    public userDetailsCommnadLineRunner(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userDetailsRepository.save(new userDetails("Raj","admin"));

        logger.info("Running user details commnad line" + Arrays.toString(args));
    }
}
