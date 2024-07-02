package com.springboot.ecommerce.controllers;


import com.springboot.ecommerce.models.Product;
import com.springboot.ecommerce.payload.ProductDTO;
import com.springboot.ecommerce.payload.ProductResponse;
import com.springboot.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product, @PathVariable Long categoryId){
            ProductDTO productDTO = productService.addProduct(product,categoryId);
            return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    };

    @GetMapping("/public/products")
    public ResponseEntity<ProductResponse> getAllProducts(){
        ProductResponse productResponse= productService.getAllProducts();


        return new ResponseEntity<>(productResponse, HttpStatus.OK);

    }

    @GetMapping("/public/categories/{categoryId}/products")
    public ResponseEntity<ProductResponse> getAllProductsByCategory(@PathVariable Long categoryId){

        ProductResponse productResponse =  productService.getProductByCategory(categoryId);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

}
