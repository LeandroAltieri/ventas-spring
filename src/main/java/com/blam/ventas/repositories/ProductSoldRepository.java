package com.blam.ventas.repositories;

import com.blam.ventas.domain.ProductSold;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSoldRepository extends CrudRepository <ProductSold, Long> {

}
