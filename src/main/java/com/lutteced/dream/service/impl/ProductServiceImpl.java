package com.lutteced.dream.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.lutteced.dream.dao.ProductRepository;
import com.lutteced.dream.dto.ProductDto;
import com.lutteced.dream.exception.DataBaseException;
import com.lutteced.dream.model.Product;
import com.lutteced.dream.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRespository;

	@Override
	public Product addProduct(ProductDto product) {
		Product entity = new Product();
		entity.setCode(product.getCode());
		entity.setExpiryTime(product.getExpiryTime());
		entity.setName(product.getName());
		try {
			entity = productRespository.save(entity);
			log.info("product added successfully with id : " + entity.getId());
		} catch (Exception e) {

			log.error("adding product details fails : " + product.toString());
			e.printStackTrace();
			throw new DataBaseException("{databse.fail.eror}");
		}
		return entity;
	}

	@Override
	public Product updateProductById(Long productId, ProductDto product) {
		log.info("update product with dew details : " + product.toString() + "by id : " + productId);
			Product result = productRespository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
			result.setCode(product.getCode());
			result.setExpiryTime(product.getExpiryTime());
			result.setName(product.getName());
			return productRespository.save(result);
	}

	@Override
	public Product getProductById(Long productId) {
		log.info("get product with dew details by id : " + productId);
		Product p = productRespository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
		return p;
	}

	@Override
	public List<Product> viewProduct() {
		log.info("Load all product :");
		try {
			List<Product> products = (List<Product>) productRespository.findAll();
			return products;
		} catch (Exception e) {
			throw new DataBaseException();
		}
		
	}

}
