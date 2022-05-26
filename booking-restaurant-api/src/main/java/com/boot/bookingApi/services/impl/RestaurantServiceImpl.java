package com.boot.bookingApi.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.bookingApi.dtos.NotFoundException;
import com.boot.bookingApi.entities.Restaurant;
import com.boot.bookingApi.exceptions.BookingException;
import com.boot.bookingApi.jsons.RestaurantRest;
import com.boot.bookingApi.repositories.IRestaurantRepository;
import com.boot.bookingApi.services.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	IRestaurantRepository restaurantRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
		return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
	}

	public List<RestaurantRest> getRestaurants() throws BookingException {
		final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
		return restaurantsEntity.stream()
								.map(service -> modelMapper.map(service, RestaurantRest.class))
								.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
		return restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESTAURANT NOT FOUND"));
	}

}
