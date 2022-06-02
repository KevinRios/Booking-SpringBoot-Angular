package com.boot.bookingApi.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingApi.dtos.NotFoundException;
import com.boot.bookingApi.entities.Reservation;
import com.boot.bookingApi.entities.Restaurant;
import com.boot.bookingApi.entities.Turn;
import com.boot.bookingApi.exceptions.BookingException;
import com.boot.bookingApi.exceptions.InternalServerErrorException;
import com.boot.bookingApi.jsons.CreateReservationRest;
import com.boot.bookingApi.jsons.ReservationRest;
import com.boot.bookingApi.repositories.IReservationRepository;
import com.boot.bookingApi.repositories.IRestaurantRepository;
import com.boot.bookingApi.repositories.ITurnRespository;
import com.boot.bookingApi.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	private IRestaurantRepository restaurantRepository;
	
	@Autowired
	private ITurnRespository turnRespository;
	
	@Autowired
	private IReservationRepository reservationRepository;

	public ReservationRest getReservation(Long reservationId) throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createReservation(final CreateReservationRest createReservationRest) throws BookingException {

		// inicio validaciones 
		// si existe el RESTAURANT y si existe el TURN
		final Restaurant restaurant = restaurantRepository
											.findById(createReservationRest.getRestaurantId())
											.orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));

		final Turn turn= turnRespository
				.findById(createReservationRest.getTurnId())
				.orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));
		
		//fin validaciones
		
		String locator = generateLocator(restaurant, createReservationRest);
		final Reservation reservation = new Reservation();
		
		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restaurant);
		reservation.setTurn(turn.getName());
		
		try {
			reservationRepository.save(reservation);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		

		return locator;
	}

	private String generateLocator(Restaurant restaurant, CreateReservationRest createReservationRest)
			throws BookingException {

		String locator = restaurant.getName() + createReservationRest.getTurnId();
		return locator;
	}

}
