package com.lutteced.dream.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.ToString;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "PRODUCT_CATALOGUE")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "PRODUCT_CATALOGUE_ID")
	private long id;
	@Column(name = "PRODUCT_CATALOGUE_NAME")
	private String name;
	@Column(name = "PRODUCT_CATALOGUE_IDENTIFICATION_CODE")
	private String code;
	@Column(name = "PRODUCT_EXPIRY")
	private String expiryTime;
	
	
	
}