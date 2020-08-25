package com.blam.ventas.bootsrap;

import com.blam.ventas.model.Category;
import com.blam.ventas.model.Product;
import com.blam.ventas.repositories.CategoryRepository;
import com.blam.ventas.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public Bootstrap(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        //Category create and save
        Category lacteos = new Category();
        lacteos.setName("Lacteos");

        categoryRepository.save(lacteos);

        Category bebidas = new Category();
        bebidas.setName("Bebidas");

        categoryRepository.save(bebidas);

        Category galletitas = new Category();
        galletitas.setName("Galletitas");

        categoryRepository.save(galletitas);

        //Product create and save
        Product leche = new Product();
        leche.setName("Milkaut Largavida 1l");
        leche.setPrice(47.90);
        leche.setCategory(lacteos);

        productRepository.save(leche);

        Product quilmes = new Product();
        quilmes.setName("Quilmes 1l");
        quilmes.setPrice(78.50);
        quilmes.setCategory(bebidas);

        productRepository.save(quilmes);

        Product pitusas = new Product();
        pitusas.setName("Pitusas 400gr");
        pitusas.setPrice(30.00);
        pitusas.setCategory(galletitas);

        productRepository.save(pitusas);

        System.out.println("Categories loaded= " +categoryRepository.count());

        System.out.println("Products loaded: " + productRepository.count());
    }
}
