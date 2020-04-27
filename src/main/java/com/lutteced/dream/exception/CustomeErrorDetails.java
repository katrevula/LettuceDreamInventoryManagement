package com.lutteced.dream.exception;

import java.util.Date;

import lombok.Data;

@Data
public class CustomeErrorDetails {
	private Date timestamp;
	private String message;
	private String errordetails;
}