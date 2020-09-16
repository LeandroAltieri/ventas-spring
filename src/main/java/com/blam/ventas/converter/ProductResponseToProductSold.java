package com.blam.ventas.converter;

import com.blam.ventas.domain.ProductSold;
import com.blam.ventas.resource.response.ProductResponse;
import com.blam.ventas.resource.response.ProductSoldResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseToProductSold implements Converter<ProductResponse, ProductSold> {
    @Override
    public ProductSold convert(ProductResponse productResponse) {
        if(productResponse == null) {
            return null;
        }
        final ProductSold sold = new ProductSold();
        sold.setName(productResponse.getName());
        sold.setQuantity(productResponse.getQuantity());
        sold.setPrice(productResponse.getPrice());
        sold.setTotal(productResponse.getTotal());
        return sold;
    }
}
