package org.springdemo.springbatch;

import org.springframework.batch.item.ItemReader;

public class Reader implements ItemReader<String> {

    private String[] courses= {"Core Java Course","Angular"};
    private  int count =0;

    @Override
    public String read() throws Exception {
        System.out.println("Inside Reader");
        if(count<courses.length){
            return courses[count++];
        }else {
            count=0;
        }
        return null;
    }
}
