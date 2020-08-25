package com.blam.ventas.converter;


import com.blam.ventas.domain.Category;
import com.blam.ventas.resource.response.CategoryResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryResponse implements Converter<Category, CategoryResponse> {

    @Override
    public CategoryResponse convert(Category category) {
        if(category==null){
            return null;
        }
        final CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(categoryResponse.getName());
        return categoryResponse;
    }
}
