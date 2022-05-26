package com.boot.bookingApi.services;

import java.util.List;

import com.boot.bookingApi.exceptions.BookingException;
import com.boot.bookingApi.jsons.RestaurantRest;

public interface RestaurantService {
	
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;
	
	public List<RestaurantRest> getRestaurants() throws BookingException;

}
