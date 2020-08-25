package com.blam.ventas.converter;

import com.blam.ventas.domain.Category;
import com.blam.ventas.resource.request.CategoryRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryRequestToCategory implements Converter<CategoryRequest, Category> {


    @Override
    public Category convert(CategoryRequest categoryRequest) {
        if(categoryRequest==null){
            return null;
        }
        final Category category = new Category();
        category.setId(category.getId());
        category.setName(category.getName());
        return category;
    }
}
