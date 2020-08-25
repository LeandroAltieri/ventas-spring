package com.blam.ventas.services;

import com.blam.ventas.domain.Product;
import com.blam.ventas.resource.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

   Product findById(Long id);


    ProductResponse findResponseById(Long id);


    List<ProductResponse> findAll();

    ProductResponse findByName(String name);

    Product findByCategory (String name);

    ProductResponse findResponseByCategory(String name);



}
