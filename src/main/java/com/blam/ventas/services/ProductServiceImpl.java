package com.blam.ventas.services;

import com.blam.ventas.converter.ProductToProductResponse;
import com.blam.ventas.domain.Product;
import com.blam.ventas.repositories.ProductRepository;
import com.blam.ventas.resource.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductToProductResponse productToProductResponse;

    public ProductServiceImpl(ProductRepository productRepository, ProductToProductResponse productToProductResponse) {
        this.productRepository = productRepository;
        this.productToProductResponse = productToProductResponse;
    }


    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
            if(!product.isPresent()) {
                throw new RuntimeException("Not found");
            }

        return product.get();
    }

    @Override
    public ProductResponse findResponseById(Long id) {
       return productToProductResponse.convert(findById(id));

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
       productRepository.findAll().iterator().forEachRemaining(products::add);
       return products;
    }


    @Override
    public List<ProductResponse> findAllResponse() {
       List<Product> products  = findAll();
        List<ProductResponse> responses = new ArrayList<>();
        products.forEach(product -> products.add(product));
        products.forEach(product -> responses.add(productToProductResponse.convert(product)));
            return responses;
    }

    @Override
    public ProductResponse findByName(String name) {
        Product product = productRepository.findByName(name);

        return productToProductResponse.convert(product);
    }


}
