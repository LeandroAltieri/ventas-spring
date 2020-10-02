package com.blam.ventas.controller;

import com.blam.ventas.converter.ProductResponseToProductSold;
import com.blam.ventas.converter.SaleRequestToSale;
import com.blam.ventas.converter.SaleToSaleResponse;
import com.blam.ventas.domain.ProductSold;
import com.blam.ventas.domain.Sale;
import com.blam.ventas.repositories.ProductSoldRepository;
import com.blam.ventas.resource.request.ProductRequest;
import com.blam.ventas.resource.request.SaleRequest;
import com.blam.ventas.resource.response.ProductResponse;
import com.blam.ventas.resource.response.SaleResponse;
import com.blam.ventas.services.ProductService;
import com.blam.ventas.services.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class SellController {

    private final SaleService saleService;
    private final ProductService productService;
    private final ProductResponseToProductSold converter;
    private final SaleRequestToSale converter1;
    private final SaleToSaleResponse converter2;

    private final ProductSoldRepository productSoldRepository;


    public ArrayList<ProductSold> productResponseArrayList = new ArrayList<>();

    public SellController(SaleService saleService, ProductService productService, ProductResponseToProductSold converter, SaleRequestToSale converter1, SaleToSaleResponse converter2, ProductSoldRepository productSoldRepository) {
        this.saleService = saleService;
        this.productService = productService;
        this.converter = converter;
        this.converter1 = converter1;
        this.converter2 = converter2;
        this.productSoldRepository = productSoldRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sell")
    public @ResponseBody
    ResponseEntity<?> getSell() {
        Double total = 0.0;

        for (ProductSold p : productResponseArrayList) {
            total += p.Total();
        }
        return new ResponseEntity<>(total, HttpStatus.OK);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/resetList")
    public @ResponseBody
    ResponseEntity<?> getResetList() {

        productResponseArrayList = new ArrayList<ProductSold>();
        return new ResponseEntity<>(productResponseArrayList, HttpStatus.OK);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(produces = "application/json", consumes = "application/json")
    @RequestMapping("/sell/add")
    public @ResponseBody
    ResponseEntity<?> addProduct(@RequestBody ProductRequest product, HttpServletRequest request) {
        //ArrayList<ProductResponse> cart = this.getCart(request);
        ProductResponse productByName = productService.findResponseByName(product.getName());
        productByName.setQuantity(product.getQuantity());
        productByName.setTotal(productByName.Total());

        ProductSold productSold = converter.convert(productByName);

        System.out.println(productByName.getPrice());
        System.out.println(productByName.Total());
       // productSoldResponse.Total();

        boolean isHere = false;

        if (productResponseArrayList.isEmpty()) {
            productResponseArrayList.add(productSold);
            isHere = true;
            System.out.println("carro vacio");
        } else {
            for (ProductSold p : productResponseArrayList) {
                if (p.getName().equals(product.getName())) {
                    isHere = true;
                    System.out.println("repitio");
                    break;

                }
            }
        }
        if (!isHere) {
            productResponseArrayList.add(productSold);
            System.out.println("no repite agrega");
        }

        System.out.println(productResponseArrayList);
        return new ResponseEntity<>(productResponseArrayList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/sell/remove/{index}")
    public @ResponseBody
    ResponseEntity<?> removeProduct(@PathVariable("index") Long index) {

        productResponseArrayList.removeIf(id -> id.getId().equals(index));

        return new ResponseEntity<>(productResponseArrayList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(consumes = "Application/json")
    @RequestMapping("sell/save")
    public @ResponseBody ResponseEntity <SaleResponse> saveSale(@RequestBody SaleRequest request){

        System.out.println(request);
        Sale sale = converter1.convert(request);
        sale.setDate(Calendar.getInstance().getTime());
        System.out.println(sale.getTotal());
        sale.setProducts(productResponseArrayList);
        //Sale saved = saleService.save(sale);

        Sale saved = saleService.save(sale);

        saved.getProducts().forEach(productSold -> {
            productSold.setId(0L);
            productSold.setSale(saved);
            productSoldRepository.save(productSold);
        });

        SaleResponse response = converter2.convert(saved);

        productResponseArrayList = new ArrayList<ProductSold>();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
