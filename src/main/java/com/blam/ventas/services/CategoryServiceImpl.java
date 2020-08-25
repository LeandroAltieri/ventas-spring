package com.blam.ventas.services;

import com.blam.ventas.converter.CategoryToCategoryResponse;
import com.blam.ventas.domain.Category;
import com.blam.ventas.repositories.CategoryRepository;
import com.blam.ventas.resource.response.CategoryResponse;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryToCategoryResponse categoryToCategoryResponse;


    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryToCategoryResponse categoryToCategoryResponse) {
        this.categoryRepository = categoryRepository;
        this.categoryToCategoryResponse = categoryToCategoryResponse;
    }

    @Override
    public Category findByName(String name) {
        Category category = categoryRepository.findByName(name);
            if(category==null){
                throw new RuntimeException("Not found");
            }
        return category;
    }

    @Override
    public CategoryResponse findCategoryResponseByName(String name) {

        return categoryToCategoryResponse.convert(findByName(name));
    }




}
