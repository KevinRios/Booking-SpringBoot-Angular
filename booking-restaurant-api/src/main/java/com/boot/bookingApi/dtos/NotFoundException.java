package com.boot.bookingApi.dtos;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.boot.bookingApi.exceptions.BookingException;

public class NotFoundException extends BookingException{

	private static final long serialVersionUID = 1L;

	
	public NotFoundException(String code, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}
	
	public NotFoundException(String code, String message, ErrorDTO data) {
		super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}


	
	
	
}
