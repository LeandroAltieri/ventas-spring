package com.blam.ventas.services;

import com.blam.ventas.converter.SaleToSaleResponse;
import com.blam.ventas.domain.Sale;
import com.blam.ventas.repositories.SaleRepository;
import com.blam.ventas.resource.response.SaleResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SaleServiceImpl implements SaleService {



    private final SaleRepository saleRepository;
    private final SaleToSaleResponse saleToSaleResponse;

    public SaleServiceImpl(SaleRepository saleRepository, SaleToSaleResponse saleToSaleResponse) {
        this.saleRepository = saleRepository;
        this.saleToSaleResponse = saleToSaleResponse;
    }

    @Override
    public Sale findById(Long id) {
       Optional <Sale> sale = saleRepository.findById(id);
        return sale.orElse(null);
    }

    @Override
    public SaleResponse findResponseById(Long id) {
        Sale sale = findById(id);
        return saleToSaleResponse.convert(sale);
    }

    @Override
    public List<Sale> findAll() {
        List<Sale> sales = new ArrayList<>();
        saleRepository.findAll().iterator().forEachRemaining(sales::add);
        return sales;
    }

    @Override
    public List<SaleResponse> findAllResponse() {
        List<Sale> sales = findAll();
        List<SaleResponse> responses = new ArrayList<>();
        sales.forEach(sale -> responses.add(saleToSaleResponse.convert(sale)));
        return responses;
    }


    @Override
    public Sale findByDate(Date date) {
        Sale sale = saleRepository.findByDate(date);
        if (sale ==null){
            return null;
        }
        return sale;
    }

    @Override
    public SaleResponse findResponseByDate(Date date) {
        Sale sale = saleRepository.findByDate(date);
        return saleToSaleResponse.convert(sale);
    }

    @Override
    public Sale newSale() {
        return new Sale();
    }




}
