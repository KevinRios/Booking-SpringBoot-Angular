package com.boot.bookingApi.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.boot.bookingApi.dtos.ErrorDTO;

public class BookingException extends Exception{

	private static final long serialVersionUID = 1L;

	private final String code;
	
	private final int responseCode;
	
	private List<ErrorDTO> errorList = new ArrayList<>() ;
	
	

	public BookingException(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}
	
	public BookingException(String code, int responseCode, String message, List<ErrorDTO> errorList) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errorList);
	}

	
	
	public List<ErrorDTO> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<ErrorDTO> errorList) {
		this.errorList = errorList;
	}

	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}
	
	
	
	
}
