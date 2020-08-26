package com.blam.ventas.repositories;

import com.blam.ventas.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends CrudRepository<Product, Long> {
    Product findByName(String name);

}
