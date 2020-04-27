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

@Data
public class ProductDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "{product.name}")
	@NotEmpty(message = "{product.name}")
	private String name;

	@NotNull(message = "{product.code}")
	@NotEmpty(message = "{product.code}")
	private String code;

	@NotNull(message = "{product.expiryTime}")
	@NotEmpty(message = "{product.expiryTime}")
	private String expiryTime;
}