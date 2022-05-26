package com.boot.bookingApi.services;

import com.boot.bookingApi.exceptions.BookingException;

public interface CancelReservationService {

	public String deleteReservation(String locator) throws BookingException;
}
