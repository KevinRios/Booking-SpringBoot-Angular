package com.boot.bookingApi.services;

import com.boot.bookingApi.exceptions.BookingException;
import com.boot.bookingApi.jsons.CreateReservationRest;
import com.boot.bookingApi.jsons.ReservationRest;

public interface  ReservationService {
	
	ReservationRest getReservation(Long reservationId) throws BookingException;
	
	String createReservation(CreateReservationRest createReservationRest) throws BookingException;

}
