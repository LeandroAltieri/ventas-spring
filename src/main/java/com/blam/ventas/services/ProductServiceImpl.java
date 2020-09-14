package com.blam.ventas.services;

import com.blam.ventas.converter.ProductRequestToProduct;
import com.blam.ventas.converter.ProductToProductResponse;
import com.blam.ventas.domain.Product;
import com.blam.ventas.exceptions.BadRequestException;
import com.blam.ventas.repositories.ProductRepository;
import com.blam.ventas.resource.request.ProductRequest;
import com.blam.ventas.resource.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductToProductResponse productToProductResponse;
    private final ProductRequestToProduct productRequestToProduct;

    public ProductServiceImpl(ProductRepository productRepository, ProductToProductResponse productToProductResponse, ProductRequestToProduct productRequestToProduct) {
        this.productRepository = productRepository;
        this.productToProductResponse = productToProductResponse;
        this.productRequestToProduct = productRequestToProduct;
    }


    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product==null){
         throw new BadRequestException("BAD REQUEST!!!!");
        }
        return product.orElse(null);

    }


    @Override
    public ProductResponse findResponseById(Long id) {
        Product product = findById(id);
        return productToProductResponse.convert(product);

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(products::add);
        return products;
    }


    @Override
    public List<ProductResponse> findAllResponse() {
        List<Product> products = findAll();
        List<ProductResponse> responses = new ArrayList<>();
        products.forEach(product -> responses.add(productToProductResponse.convert(product)));
        return responses;
    }

    @Override
    public Product findByName(String name) {
        Product product = productRepository.findByName(name);
            if(product == null) {
               throw new BadRequestException("BAD REQUEST!!!!");
            }
            return product;
    }

    @Override
    public ProductResponse findResponseByName(String name) {
        Product product = productRepository.findByName(name);

        return productToProductResponse.convert(product);
    }

    @Override
    public ProductResponse newProduct(ProductRequest productRequest) {

         ProductResponse responseByName = findResponseByName(productRequest.getName());
         if(responseByName == null){
           Product product =  productRequestToProduct.convert(productRequest);
           productRepository.save(product);
           return productToProductResponse.convert(product);
         }
         throw new BadRequestException("BAD REQUEST!!!!");

    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        ProductResponse productResponse = findResponseById(productRequest.getId());
        productResponse.setName(productRequest.getName());
        productResponse.setPrice(productRequest.getPrice());

        productRepository.save(productRequestToProduct.convert(productRequest));
        return productResponse;
    }

    @Override
    public void deleteById(Long id) {
      productRepository.deleteById(id);

    }
}