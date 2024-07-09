package org.springdemo.springbatch;

import org.springframework.batch.item.ItemProcessor;

public class JobProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String item) throws Exception {
        System.out.println("Inside the process method");
        return "Processed " + item.toUpperCase();
    }
}
