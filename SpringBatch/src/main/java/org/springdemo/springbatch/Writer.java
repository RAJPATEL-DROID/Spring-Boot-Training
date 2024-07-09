package org.springdemo.springbatch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter {


    @Override
    public void write(Chunk chunk) throws Exception {
        System.out.println("Writing data of size" + chunk.size());
        System.out.println("Chunk data : "  + chunk.toString());
    }
}
