package org.springdemo.multithreading.repository;

import org.springdemo.multithreading.model.Book;
import org.springframework.stereotype.Repository;

public interface BookRepository {

    Book getByAuthor(String author) throws InterruptedException;
}
