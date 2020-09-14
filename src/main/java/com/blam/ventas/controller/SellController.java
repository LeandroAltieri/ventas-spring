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
    public ArrayList<ProductResponse>productResponseArrayList = new ArrayList<>();
    public SellController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sell")
    public @ResponseBody ResponseEntity<?> getSell (HttpServletRequest request){
        Double total = 0.0;
        //ProductResponse response = new ProductResponse();
        //ArrayList<ProductResponse> cart = this.getCart(request);

        for(ProductResponse p : productResponseArrayList){
            total += p.Total();
        }
        return new ResponseEntity<>(total, HttpStatus.OK);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(produces = "application/json", consumes = "application/json")
    @RequestMapping("/sell/add")
    public @ResponseBody ResponseEntity<?> addProduct(@RequestBody ProductRequest product, HttpServletRequest request){
        //ArrayList<ProductResponse> cart = this.getCart(request);
        ProductResponse productByName= productService.findResponseByName(product.getName());
        productByName.setQuantity(product.getQuantity());
        productByName.setTotal(productByName.Total());
        System.out.println(productByName.getPrice());
        System.out.println(productByName.Total());
        productByName.Total();

        boolean isHere = false;

        if (productResponseArrayList.isEmpty()) {
            productResponseArrayList.add(productByName);
            isHere = true;
            System.out.println("carro vacio");
        } else  {
            for (ProductResponse productResponse : productResponseArrayList) {
                if (productResponse.getName().equals(product.getName())) {
                    isHere = true;
                    System.out.println("repitio");
                    break;

                }
            }
        }
        if (!isHere) {
            productResponseArrayList.add(productByName);
            System.out.println("no repite agrega");
        }

        System.out.println(productResponseArrayList);
        //this.saveCart(productResponseArrayList, request);
        return new ResponseEntity<>(productResponseArrayList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/sell/remove/{index}")
    public @ResponseBody ResponseEntity<?> removeProduct(@PathVariable("index") Long index){

        //ArrayList<ProductResponse> cart = this.getCart(request);
        //ProductResponse productToRemove =  cart.get(index);

        productResponseArrayList.removeIf(id -> id.getId().equals(index));

        //cart.remove(productToRemove);
       // this.saveCart(cart, request);
        return new ResponseEntity<>(productResponseArrayList ,HttpStatus.OK);
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
