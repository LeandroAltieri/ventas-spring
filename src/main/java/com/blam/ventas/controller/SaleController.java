package com.blam.ventas.controller;

import com.blam.ventas.converter.SaleRequestToSale;
import com.blam.ventas.converter.SaleToSaleResponse;
import com.blam.ventas.domain.ProductSold;
import com.blam.ventas.domain.Sale;
import com.blam.ventas.exceptions.BadRequestException;
import com.blam.ventas.resource.request.SaleRequest;
import com.blam.ventas.resource.response.SaleResponse;
import com.blam.ventas.services.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class SaleController {

    private final SaleService saleService;


    public SaleController(SaleService saleService) {
        this.saleService = saleService;

    }

    // para commitear
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sales/list")
    public @ResponseBody
    ResponseEntity<List<SaleResponse>> getAllSales() {
        List<SaleResponse> sales = saleService.findAllResponse();

        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("sales/id/{id}")
    public @ResponseBody
    ResponseEntity<SaleResponse> getSaleById(@PathVariable Long id) {
        SaleResponse sale = saleService.findResponseById(id);
        if (sale == null) {
            throw new BadRequestException("BAD REQUEST!!!!");
        }
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("sales/date/{date}")
    public @ResponseBody
    ResponseEntity<SaleResponse> getSaleByDate(@PathVariable Date date) {
        return new ResponseEntity<>(saleService.findResponseByDate(date), HttpStatus.OK);
    }

}