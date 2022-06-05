package com.boot.bookingApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingApi.exceptions.BookingException;
import com.boot.bookingApi.jsons.CreateReservationRest;
import com.boot.bookingApi.responses.BookingResponse;
import com.boot.bookingApi.services.ReservationService;

@RestController
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation",
			method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest)
			throws BookingException {
		
		BookingResponse<String> responseBooking =new BookingResponse<>("sucess", String.valueOf(HttpStatus.OK), "OK",
				reservationService.createReservation(createReservationRest));

		return responseBooking;

	}

}
