package com.blam.ventas.controller;

import com.blam.ventas.domain.Product;
import com.blam.ventas.model.ProductToSale;
import com.blam.ventas.resource.request.ProductRequest;
import com.blam.ventas.resource.request.ProductSoldRequest;
import com.blam.ventas.resource.response.ProductResponse;
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

    public SellController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    @GetMapping("/sell")
    public @ResponseBody ResponseEntity<?> getSell (HttpServletRequest request){
        Double total = 0.0;
        ProductResponse response = new ProductResponse();
        ArrayList<ProductResponse> cart = this.getCart(request);
        for(ProductResponse p : cart){
            total += p.Total();
        }

        return new ResponseEntity<>(cart,  HttpStatus.OK);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @RequestMapping("/sell/add")
    public @ResponseBody ResponseEntity<?> addProduct(@RequestBody ProductRequest product, HttpServletRequest request){
        ArrayList<ProductResponse> cart = this.getCart(request);
        ProductResponse productByName= productService.findResponseByName(product.getName());
        productByName.setQuantity(product.getQuantity());
        cart.add(productByName);
        this.saveCart(cart, request);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping(value = "/sell/remove/{index}")
    public @ResponseBody ResponseEntity<?> removeProduct(@PathVariable("index") Integer index, HttpServletRequest request){
        ArrayList<ProductResponse> cart = this.getCart(request);
        ProductResponse productToRemove =  cart.get(index);
        cart.remove(productToRemove);
        this.saveCart(cart, request);
        return new ResponseEntity<>(cart ,HttpStatus.OK);
    }







    private ArrayList<ProductResponse> getCart(HttpServletRequest request){
        ArrayList<ProductResponse> cart = (ArrayList<ProductResponse>) request.getSession().getAttribute("cart");
        if(cart ==null){
            cart = new ArrayList<>();
        }
        return cart;
    }

    private void saveCart(ArrayList<ProductResponse> cart, HttpServletRequest request){
        request.getSession().setAttribute("cart" , cart);
    }

    private void cleanCart(HttpServletRequest request){
        this.saveCart(new ArrayList<>(), request);
    }
}
