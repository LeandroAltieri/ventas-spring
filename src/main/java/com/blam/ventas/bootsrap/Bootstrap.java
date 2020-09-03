package com.blam.ventas.bootsrap;

import com.blam.ventas.domain.Product;
import com.blam.ventas.domain.ProductSold;
import com.blam.ventas.domain.Sale;
import com.blam.ventas.repositories.ProductRepository;
import com.blam.ventas.repositories.ProductSoldRepository;
import com.blam.ventas.repositories.SaleRepository;
import com.blam.ventas.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Component
public class Bootstrap implements CommandLineRunner {


    private final ProductRepository productRepository;
    private final ProductService productService;
    private final SaleRepository saleRepository;
    private final ProductSoldRepository productSoldRepository;

    public Bootstrap(ProductRepository productRepository, ProductService productService, SaleRepository saleRepository, ProductSoldRepository productSoldRepository) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.saleRepository = saleRepository;
        this.productSoldRepository = productSoldRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Sale sale  = new Sale();

        //Product create and save
        Product leche = new Product();
        leche.setName("Milkaut");
        leche.setPrice(47.90);


        productRepository.save(leche);

        Product quilmes = new Product();
        quilmes.setName("Quilmes");
        quilmes.setPrice(78.50);


        productRepository.save(quilmes);

        Product pitusas = new Product();
        pitusas.setName("Pitusas");
        pitusas.setPrice(30.00);


        productRepository.save(pitusas);

        ProductSold productSold = new ProductSold();
        productSold.setName("papa");
        productSold.setPrice(200.0);
        productSold.setQuantity(10.0);


        productSoldRepository.save(productSold);

        ProductSold productSold2 = new ProductSold();
        productSold2.setName("popa");
        productSold2.setPrice(200.0);
        productSold2.setQuantity(10.0);


        productSoldRepository.save(productSold2);

        ProductSold productSold3 = new ProductSold();
        productSold3.setName("caca");
        productSold3.setPrice(200.0);
        productSold3.setQuantity(10.0);


        productSoldRepository.save(productSold3);


       List<ProductSold> products = new ArrayList<>();
        products.add(productSold);
        products.add(productSold2);
        products.add(productSold3);

        //Sale sale  = new Sale();
        sale.setClientName("porota");
        sale.setProducts(products);
        sale.setDate(Calendar.getInstance().getTime());
        sale.setTotal(sale.getTotal());

        saleRepository.save(sale);

        productSold.setSale(sale);
        productSold2.setSale(sale);
        productSold3.setSale(sale);
        productSoldRepository.save(productSold);
        productSoldRepository.save(productSold2);
        productSoldRepository.save(productSold3);

        saleRepository.save(sale);


        System.out.println("Products loaded: " + productRepository.count());

        System.out.println("Products list: " + productRepository.findAll().toString());

        System.out.println("Product Response " + productService.findAll());

        System.out.println("Product by name " + productService.findByName("Quilmes").toString());

        //System.out.println("Sale date:" + sale.getDate().toString());
    }
}
