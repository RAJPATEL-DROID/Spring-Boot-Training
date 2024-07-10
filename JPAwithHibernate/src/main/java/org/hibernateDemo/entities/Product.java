package org.hibernateDemo.entities;

import jakarta.persistence.*;

//@Entity -> Query using the Super Class object in Jpql
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@MappedSuperclass // -> To Store Common Attributes in Super Class
public abstract class Product {

    @Id
    protected long id;

    protected String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}