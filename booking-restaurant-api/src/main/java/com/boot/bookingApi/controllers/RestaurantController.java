package com.boot.bookingApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingApi.exceptions.BookingException;
import com.boot.bookingApi.jsons.RestaurantRest;
import com.boot.bookingApi.responses.BookingResponse;
import com.boot.bookingApi.services.RestaurantService;

@RestController
@RequestMapping(path = "/booking-restaurant" + "v1")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	
	public BookingResponse<RestaurantRest> getRestaurantById(Long restaurantId) throws BookingException{
		
		return new BookingResponse<>("sucess", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurantById(restaurantId));
	}

}
