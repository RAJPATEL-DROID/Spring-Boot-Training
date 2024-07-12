package org.springdemo.service;

import org.springdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public void addOneProduct() {

        repository.addProduct("Rja");
        throw new RuntimeException("rollback");
    }

    @Transactional(rol)
    public void addTenProduct(){
        for (int i=0; i<10;i++) {
            repository.addProduct("Product" + i);
//            if(i == 5) throw new RuntimeException();
        }
    }

}