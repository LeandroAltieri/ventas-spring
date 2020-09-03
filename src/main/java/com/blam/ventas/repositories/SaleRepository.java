package com.blam.ventas.repositories;

import com.blam.ventas.domain.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long > {

    Sale findByDate(Date date);
}
