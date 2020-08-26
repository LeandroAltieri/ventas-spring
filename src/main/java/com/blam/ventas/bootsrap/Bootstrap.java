package com.blam.ventas.bootsrap;

import com.blam.ventas.domain.Product;
import com.blam.ventas.repositories.ProductRepository;
import com.blam.ventas.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Bootstrap implements CommandLineRunner {


    private ProductRepository productRepository;
    private ProductService productService;

    public Bootstrap(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {


        //Product create and save
        Product leche = new Product();
        leche.setName("Milkaut Largavida 1l");
        leche.setPrice(47.90);


        productRepository.save(leche);

        Product quilmes = new Product();
        quilmes.setName("Quilmes 1l");
        quilmes.setPrice(78.50);


        productRepository.save(quilmes);

        Product pitusas = new Product();
        pitusas.setName("Pitusas 400gr");
        pitusas.setPrice(30.00);


        productRepository.save(pitusas);


        System.out.println("Products loaded: " + productRepository.count());

        System.out.println("Products list: " + productRepository.findAll().toString());

        System.out.println("Product Response " + productService.findAll());

        System.out.println("Product by name " + productService.findByName("Quilmes 1l").toString());


    }
}
