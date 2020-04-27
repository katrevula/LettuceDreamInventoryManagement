package com.lutteced.dream.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	private boolean status;
	private int statusCode;
	private String message;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;
	private Object result;
	
	public static Response ok(Object result,String message) {
		return new Response(true, 200, message, new Date(), result);	
	}
	
	
	public static Response serverError(Object result,String message) {
		return new Response(false, 500, message, new Date(), result);	
	}
	public static Response resourceNotFound(Object result,String message) {
		return new Response(false, 404, message, new Date(), result);	
	}
	
}