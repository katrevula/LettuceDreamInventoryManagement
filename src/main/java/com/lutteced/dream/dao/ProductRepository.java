package com.lutteced.dream.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.lutteced.dream.model.Product;

@Repository
public interface ProductRepository  extends CrudRepository<Product, Long>{
	
}