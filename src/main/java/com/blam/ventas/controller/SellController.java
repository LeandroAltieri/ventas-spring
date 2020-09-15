package com.blam.ventas.controller;

import com.blam.ventas.converter.ProductResponseToProductSoldResponse;
import com.blam.ventas.resource.request.ProductRequest;
import com.blam.ventas.resource.response.ProductResponse;
import com.blam.ventas.resource.response.ProductSoldResponse;
import com.blam.ventas.services.ProductService;
import com.blam.ventas.services.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
public class SellController {

    private final SaleService saleService;
    private final ProductService productService;
    private final ProductResponseToProductSoldResponse converter;

    public ArrayList<ProductSoldResponse> productResponseArrayList = new ArrayList<>();

    public SellController(SaleService saleService, ProductService productService, ProductResponseToProductSoldResponse converter) {
        this.saleService = saleService;
        this.productService = productService;
        this.converter = converter;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sell")
    public @ResponseBody
    ResponseEntity<?> getSell() {
        Double total = 0.0;
        for (ProductSoldResponse p : productResponseArrayList) {
            total += p.Total();
        }
        return new ResponseEntity<>(total, HttpStatus.OK);

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

        ProductSoldResponse productSoldResponse = converter.convert(productByName);

        System.out.println(productByName.getPrice());
        System.out.println(productByName.Total());
       // productSoldResponse.Total();

        boolean isHere = false;

        if (productResponseArrayList.isEmpty()) {
            productResponseArrayList.add(productSoldResponse);
            isHere = true;
            System.out.println("carro vacio");
        } else {
            for (ProductSoldResponse productResponse : productResponseArrayList) {
                if (productResponse.getName().equals(product.getName())) {
                    isHere = true;
                    System.out.println("repitio");
                    break;

                }
            }
        }
        if (!isHere) {
            productResponseArrayList.add(productSoldResponse);
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


}