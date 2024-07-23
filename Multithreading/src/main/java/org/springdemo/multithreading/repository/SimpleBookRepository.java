package org.springdemo.multithreading.repository;

import org.springdemo.multithreading.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleBookRepository implements BookRepository{

    @Cacheable("books")
    @Override
    public Book getByAuthor(String author) throws InterruptedException {
        slowServiceSimulation();
        return new Book(author,"SomeBook");
    }

    private void slowServiceSimulation() throws InterruptedException {
        try{
            Thread.sleep(3000l);
        }catch (InterruptedException exception){
            throw new InterruptedException();
        }
    }
}
