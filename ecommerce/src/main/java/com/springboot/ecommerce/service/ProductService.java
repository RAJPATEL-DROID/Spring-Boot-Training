package com.springboot.ecommerce.service;

import com.springboot.ecommerce.models.Product;
import com.springboot.ecommerce.payload.ProductDTO;
import com.springboot.ecommerce.payload.ProductResponse;

public interface ProductService {
    ProductResponse getAllProducts();

    ProductResponse getProductByCategory(Long categoryId);

    ProductDTO addProduct(Product product, Long categoryId);

    ProductDTO updateProduct(ProductDTO productDTO, Long productId);





}
