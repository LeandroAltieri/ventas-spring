package com.blam.ventas.converter;

import com.blam.ventas.domain.Product;
import com.blam.ventas.domain.ProductSold;
import com.blam.ventas.model.ProductToSale;
import org.springframework.core.convert.converter.Converter;

public class ProductToSaleToProductSold implements Converter<ProductToSale, ProductSold> {
    @Override
    public ProductSold convert(ProductToSale productToSale) {
        if(productToSale==null) {
            return null;
        }
        final ProductSold productSold = new ProductSold();
        productSold.setName(productToSale.getName());
        productSold.setQuantity(productToSale.getQuantity());
        productSold.setPrice(productToSale.getPrice());
        return productSold;
    }
}
