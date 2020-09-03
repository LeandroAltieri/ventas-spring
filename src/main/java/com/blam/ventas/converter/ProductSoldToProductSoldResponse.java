package com.blam.ventas.converter;

import com.blam.ventas.domain.ProductSold;
import com.blam.ventas.resource.response.ProductSoldResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductSoldToProductSoldResponse implements Converter<ProductSold, ProductSoldResponse> {
    @Override
    public ProductSoldResponse convert(ProductSold productSold) {
        if(productSold == null) {
            return null;
        }
        final ProductSoldResponse response = new ProductSoldResponse();
        response.setId(productSold.getId());
        response.setName(productSold.getName());
        response.setPrice(productSold.getPrice());
        response.setQuantity(productSold.getQuantity());
        return response;
    }
}
