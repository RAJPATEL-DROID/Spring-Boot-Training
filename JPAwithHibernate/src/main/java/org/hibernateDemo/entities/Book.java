package org.hibernateDemo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany(mappedBy = "booksList")
    private List<Author> authorsList;

    @ManyToMany(mappedBy = "booksList")
    private List<BookShop> bookShopsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Author> authors) {
        this.authorsList = authors;
    }

    public List<BookShop> getBookShopList() {
        return bookShopsList;
    }

    public void setBookShopList(List<BookShop> bookShopList) {
        this.bookShopsList = bookShopList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}