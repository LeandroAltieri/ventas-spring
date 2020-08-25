package com.blam.ventas.services;

import com.blam.ventas.domain.Category;
import com.blam.ventas.resource.response.CategoryResponse;

public interface CategoryService {

    Category findByName(String name);

    CategoryResponse findCategoryResponseByName(String name);
}
