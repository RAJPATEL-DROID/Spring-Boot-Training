package com.springboot.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String image;
    private String description;
    private double price;
    private Integer quantity;
    private double discount;
    private double specialPrice;

    @ManyToOne
    @JoinColumn(name="category_Id")
    private Category category;

}
