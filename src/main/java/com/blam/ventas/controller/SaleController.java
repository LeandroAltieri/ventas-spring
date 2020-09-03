package com.blam.ventas.controller;

import com.blam.ventas.domain.ProductSold;
import com.blam.ventas.domain.Sale;
import com.blam.ventas.model.ProductToSale;
import com.blam.ventas.resource.response.SaleResponse;
import com.blam.ventas.services.SaleService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }


    @GetMapping("/sales/list")
    public @ResponseBody ResponseEntity<List<SaleResponse>> getAllSales(){
        List<SaleResponse> sales = saleService.findAllResponse();
            if(sales ==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(sales, HttpStatus.OK);
    }



   /* @GetMapping("/sales/new")
    public @ResponseBody ResponseEntity<Sale> newSale(){
         return new ResponseEntity<>(saleService.newSale(), HttpStatus.OK);

    }

    @GetMapping("sales/id/{id}")
    public @ResponseBody ResponseEntity<SaleResponse> getSaleById(@PathVariable Long id){
        return new ResponseEntity<>(saleService.findResponseById(id), HttpStatus.OK);
    }

    @GetMapping("sales/date/{date}")
    public @ResponseBody ResponseEntity<SaleResponse> getSaleByDate(@PathVariable Date date){
        return new ResponseEntity<>(saleService.findResponseByDate(date), HttpStatus.OK);
    }*/








    private ArrayList<ProductToSale> getCart(HttpServletRequest request){
        ArrayList<ProductToSale> cart = (ArrayList<ProductToSale>) request.getSession().getAttribute("cart");
        if(cart ==null){
            cart = new ArrayList<>();
        }
        return cart;
     }

    private void saveCart(ArrayList<ProductToSale> cart, HttpServletRequest request){
        request.getSession().setAttribute("cart" , cart);
    }

}
