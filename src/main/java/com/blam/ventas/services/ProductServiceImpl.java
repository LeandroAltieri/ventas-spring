package com.blam.ventas.services;

import com.blam.ventas.converter.ProductToProductResponse;
import com.blam.ventas.domain.Product;
import com.blam.ventas.repositories.ProductRepository;
import com.blam.ventas.resource.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    public List<ProductResponse> findAll() {
       List<Product> products  = new ArrayList<>();
        products.forEach(product -> products.add(product));
        List<ProductResponse> responses = new ArrayList<>();
        for (Product product : products){
           responses.add(productToProductResponse.convert(product));
        }
            return responses;
    }

    @Override
    public ProductResponse findByName(String name) {
        Product product = productRepository.findByName(name);

        return productToProductResponse.convert(product);
    }

    @Override
    public Product findByCategory(String name) {
        Product product = productRepository.findByCategoryName(name);
            if(product ==null){
                throw new RuntimeException("Not Found");
            }
        return product;
    }

    @Override
    public ProductResponse findResponseByCategory(String name) {
        return productToProductResponse.convert(findByCategory(name));
    }
}
