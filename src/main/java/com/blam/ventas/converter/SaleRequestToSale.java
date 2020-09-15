package com.blam.ventas.converter;

import com.blam.ventas.domain.Sale;
import com.blam.ventas.resource.request.SaleRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaleRequestToSale implements Converter<SaleRequest, Sale> {
    @Override
    public Sale convert(SaleRequest saleRequest) {
        if(saleRequest==null) {
            return null;
        }
        final Sale sale = new Sale();
        sale.setId(saleRequest.getId());
        sale.setClientName(saleRequest.getClientName());
        sale.setDate(saleRequest.getDate());
        sale.setProducts(saleRequest.getProductsSold());
        sale.setTotal(saleRequest.getTotal());

        return sale;
    }
}
