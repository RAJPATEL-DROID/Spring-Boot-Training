package org.springdemo;

import org.springdemo.config.Config;
import org.springdemo.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {


        try(var c= new AnnotationConfigApplicationContext(Config.class)){
            ProductService productService= c.getBean(ProductService.class);
            productService.addTenProduct();
        }
    }
}