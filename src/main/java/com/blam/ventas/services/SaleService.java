package com.blam.ventas.services;


import com.blam.ventas.domain.Sale;
import com.blam.ventas.repositories.SaleRepository;
import com.blam.ventas.resource.response.SaleResponse;


import java.util.Date;
import java.util.List;

public interface SaleService {

    Sale findById(Long id);

    SaleResponse findResponseById(Long id);

    List<Sale> findAll();

    List<SaleResponse> findAllResponse();

    Sale findByDate(Date date);

    SaleResponse findResponseByDate(Date date);

    Sale newSale();

    Sale save(Sale sale);



}
