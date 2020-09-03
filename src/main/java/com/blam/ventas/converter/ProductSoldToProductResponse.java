package com.blam.ventas.converter;

import com.blam.ventas.domain.ProductSold;
import com.blam.ventas.resource.response.ProductResponse;
import org.springframework.core.convert.converter.Converter;

public class ProductSoldToProductResponse implements Converter<ProductSold, ProductResponse> {
    @Override
    public ProductResponse convert(ProductSold productSold) {
        if(productSold == null) {
            return null;
        }
        final ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productSold.getId());
        productResponse.setName(productSold.getName());
        productResponse.setPrice(productSold.getPrice());
        productResponse.setQuantity(productSold.getQuantity());
        return  productResponse;
    }

}
