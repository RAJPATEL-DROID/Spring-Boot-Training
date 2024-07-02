package com.springboot.ecommerce.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMaper(){
        return new ModelMapper();
    }

}
