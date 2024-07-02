package com.springboot.ecommerce.service;

import com.springboot.ecommerce.exception.APIException;
import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.models.Category;
import com.springboot.ecommerce.payload.CategoryDTO;
import com.springboot.ecommerce.payload.CategoryResponse;
import com.springboot.ecommerce.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    //private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()){
            throw new APIException("No Category created till now");
        }
        List<CategoryDTO> categoryDTOs = categories.stream()
                .map(category ->modelMapper.map(category, CategoryDTO.class) )
                .toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOs);
        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO,Category.class);

        Category categoryFromDB = categoryRepository.findByCategoryName(category.getCategoryName());
        if (categoryFromDB != null)
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists !!!");
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));

        categoryRepository.delete(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Category category  = modelMapper.map(categoryDTO, Category.class);

        category.setCategoryId(categoryId);

        savedCategory = categoryRepository.save(category);

        return modelMapper.map(savedCategory, CategoryDTO.class);
    }
}