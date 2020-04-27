package com.lutteced.dream.service;

import java.util.List;

import com.lutteced.dream.dto.ProductDto;
import com.lutteced.dream.model.Product;

// This interface contain the product functionality prototypes
public interface ProductService {
	public Product addProduct(ProductDto product);
	public  List<Product>  viewProduct();
	public Product getProductById(Long productId);
	public Product  updateProductById(Long productId,ProductDto product);
}