package com.blam.ventas.converter;

import com.blam.ventas.domain.Product;
import com.blam.ventas.resource.response.ProductResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductResponse implements Converter <Product, ProductResponse> {

    @Override
    public ProductResponse convert(Product product) {
        if(product ==null) {
            return null;
        }
        final ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());

        return productResponse;
    }



}
