package com.blam.ventas.converter;

import com.blam.ventas.domain.Product;
import com.blam.ventas.resource.request.ProductRequest;
import org.springframework.core.convert.converter.Converter;

public class ProductRequestToProduct implements Converter<ProductRequest, Product> {

    @Override
    public Product convert(ProductRequest productRequest) {
        if(productRequest ==null){
            return null;
        }
        final Product product = new Product();
        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());

        return product;
    }
}
