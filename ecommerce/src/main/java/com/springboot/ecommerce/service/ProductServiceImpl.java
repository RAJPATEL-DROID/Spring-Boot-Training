package com.springboot.ecommerce.service;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.models.Category;
import com.springboot.ecommerce.models.Product;
import com.springboot.ecommerce.payload.ProductDTO;
import com.springboot.ecommerce.payload.ProductResponse;
import com.springboot.ecommerce.repositories.CategoryRepository;
import com.springboot.ecommerce.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductResponse getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product,ProductDTO.class))
                .toList();

        ProductResponse productResponse = new ProductResponse();
        productResponse.setProducts(productDTOS);
        return productResponse;
    }


    @Override
    public ProductResponse getProductByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(ResourceNotFoundException::new);

        List<Product> products =  productRepository.findByCategory(category);

        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product,ProductDTO.class))
                .toList();

        ProductResponse productResponse = new ProductResponse();

        productResponse.setProducts(productDTOS);

        return productResponse;
    }

    @Override
    public ProductDTO addProduct(Product product, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        product.setImage("default.png");

        product.setCategory(category);

        double specialPrice = product.getPrice() - ( (product.getDiscount()* 0.01) * product.getPrice());

        product.setSpecialPrice(specialPrice);

        return modelMapper.map(productRepository.save(product), ProductDTO.class);


    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long productId) {
        return null;
    }
}
