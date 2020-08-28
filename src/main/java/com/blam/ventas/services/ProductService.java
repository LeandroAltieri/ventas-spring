package com.blam.ventas.services;

import com.blam.ventas.domain.Product;
import com.blam.ventas.resource.request.ProductRequest;
import com.blam.ventas.resource.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

   Product findById(Long id);


    ProductResponse findResponseById(Long id);

    List<Product> findAll();

    List<ProductResponse> findAllResponse();

    Product findByName(String name);
    ProductResponse findResponseByName(String name);

    ProductResponse newProduct(ProductRequest productRequest);

    ProductResponse updateProduct(ProductRequest productRequest);

    void deleteById(Long id);







}
