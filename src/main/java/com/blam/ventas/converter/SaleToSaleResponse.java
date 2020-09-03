package com.blam.ventas.converter;

import com.blam.ventas.domain.Sale;
import com.blam.ventas.resource.response.SaleResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaleToSaleResponse implements Converter<Sale, SaleResponse> {

    private final ProductSoldToProductSoldResponse converter;

    public SaleToSaleResponse(ProductSoldToProductSoldResponse converter) {
        this.converter = converter;
    }

    @Override
    public SaleResponse convert(Sale sale) {
        if(sale ==null){
            return null;
        }
        final SaleResponse saleResponse = new SaleResponse();
        saleResponse.setId(sale.getId());
        saleResponse.setClientName(sale.getClientName());
        saleResponse.setDate(sale.getDate());
        saleResponse.setProductSoldResponse(sale.getProducts());
        saleResponse.setTotal(sale.getTotal());
        return saleResponse;
    }
}
