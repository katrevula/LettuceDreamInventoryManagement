package com.lutteced.dream.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lutteced.dream.dto.ProductDto;
import com.lutteced.dream.dto.Response;
import com.lutteced.dream.exception.DataBaseException;
import com.lutteced.dream.model.Product;
import com.lutteced.dream.service.ProductService;

import lombok.extern.slf4j.Slf4j;
// This annotation denotes that this class is a RestController class.
// If we write this annotation on the top of class then it is optional to write any stereotype 
// annotation explicitly to tell that this class is a spring bean.
@RestController

// This annotation is class level annotation and it is mapping /product URL to the class. 
// Whenever request comes with /product then this class this class gets called.
@RequestMapping("/product")
@Slf4j
public class ProductController {

	// This annotation informs the container for automatic dependency management by type
	@Autowired
	private ProductService service;
	// This annotation map the request comes with /product/add to the addProduct() method
	@PostMapping("/add")
	// adding the validation
	public ResponseEntity<Response> addProduct(@Valid @RequestBody ProductDto product) {
		log.info("request came for adding product with details : " + product.toString());
		// Adding try catch for exception handeling
		try {
			// calling the addProduct() method of service bean and storing the result
		// in product Model object called result.
			Product result = service.addProduct(product);
			// Created a new Response object and returned the response
			return new ResponseEntity<Response>(Response.ok(result, "Product details added successfully"),
					HttpStatus.OK);
		} catch (DataBaseException e) {
			// Created a new Response object and returned the response with error msg
			
			return new ResponseEntity<Response>(Response.serverError("", "Server error,Please try later"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// The request for update in product
	@PostMapping("/update/{productId}")
	public ResponseEntity<Response> updateProductbyId(@Valid @PathVariable(value = "productId") Long productId,
			@Valid @RequestBody ProductDto product) {
		try {
			Product result = service.updateProductById(productId, product);
			return new ResponseEntity<Response>(Response.ok(result, "Product details updated successfully"),
					HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<Response>(Response.resourceNotFound("", "Product details does not exist"),
					HttpStatus.NOT_FOUND);
		} 

	}

	@GetMapping("/get-product/{productId}")
	public ResponseEntity<Response> getProductById(@PathVariable(value = "productId") Long productId) {
		try {
			Product result = service.getProductById(productId);
			return new ResponseEntity<Response>(Response.ok(result, "Product details"),
					HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<Response>(Response.resourceNotFound("", "Product details does not exist"),
					HttpStatus.NOT_FOUND);
		} 
	}

	@GetMapping("/view-product")
	public ResponseEntity<Response> getAllProduct() {
		try {
			List<Product> result = service.viewProduct();
			return new ResponseEntity<Response>(Response.ok(result, "Product List"),
					HttpStatus.OK);
		} catch (DataBaseException e) {
			return new ResponseEntity<Response>(Response.serverError("", "Server error,Please try later"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

}
