package com.lutteced.dream.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Validations
@Data
public class ProductDto implements Serializable {

	private static final long serialVersionUID = 1L;
       // Error message if field is null
	@NotNull(message = "{product.name}")
	
       // Error message if field is Empty
	@NotEmpty(message = "{product.name}")
	private String name;

	@NotNull(message = "{product.code}")
	// Error message if field is null
	@NotEmpty(message = "{product.code}")
	private String code;
        // Error message if field is null
	@NotNull(message = "{product.expiryTime}")
	// Error message if field is null
	@NotEmpty(message = "{product.expiryTime}")
	private String expiryTime;
}
