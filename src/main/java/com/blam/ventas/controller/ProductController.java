package com.blam.ventas.controller;




import com.blam.ventas.resource.request.ProductRequest;
import com.blam.ventas.resource.response.ProductResponse;
import com.blam.ventas.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value= "/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long id){
        ProductResponse product = productService.findResponseById(id);
        if (product!=null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/sales/{name}", produces = "application/json")
    public @ResponseBody ResponseEntity<ProductResponse> getProductByName(@PathVariable("name") String name){
        ProductResponse product = productService.findResponseByName(name);
        if(product !=null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/products",produces = "application/json")
    public @ResponseBody ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> products = productService.findAllResponse();
        if(products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(products , HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/edit" )
    public @ResponseBody ResponseEntity<ProductResponse> editProductForm(@PathVariable("id") Long id){
        ProductResponse product = productService.findResponseById(id);
            if(product!=null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(produces = "application/json", consumes = "application/json")
    @RequestMapping(value = "/new")
    public @ResponseBody ResponseEntity<ProductResponse> newProduct(@RequestBody ProductRequest productRequest){
           return new ResponseEntity<>(productService.newProduct(productRequest), HttpStatus.CREATED);
    }

    @PutMapping(produces = "application/json", consumes = "application/json",value = "/{id}/edit")
    public @ResponseBody ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductRequest productRequest){
       return new ResponseEntity<>(productService.updateProduct(productRequest), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "{id}/delete")
    public @ResponseBody ResponseEntity deleteById(@PathVariable("id") Long id){
        productService.deleteById(id);
       return new ResponseEntity(HttpStatus.OK);
    }

}
