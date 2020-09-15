package com.blam.ventas.converter;

import com.blam.ventas.resource.response.ProductResponse;
import com.blam.ventas.resource.response.ProductSoldResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseToProductSoldResponse implements Converter<ProductResponse, ProductSoldResponse> {
    @Override
    public ProductSoldResponse convert(ProductResponse productResponse) {
        if(productResponse == null) {
            return null;
        }
        final ProductSoldResponse sold = new ProductSoldResponse();
        sold.setName(productResponse.getName());
        sold.setQuantity(productResponse.getQuantity());
        sold.setPrice(productResponse.getPrice());
        sold.setTotal(productResponse.getTotal());
        return sold;
    }
}
