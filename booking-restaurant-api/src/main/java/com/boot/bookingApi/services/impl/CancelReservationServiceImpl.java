package com.boot.bookingApi.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingApi.dtos.NotFoundException;
import com.boot.bookingApi.entities.Reservation;
import com.boot.bookingApi.exceptions.BookingException;
import com.boot.bookingApi.exceptions.InternalServerErrorException;
import com.boot.bookingApi.repositories.IReservationRepository;
import com.boot.bookingApi.services.CancelReservationService;

@Service
public class CancelReservationServiceImpl implements CancelReservationService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationService.class);


	@Autowired
	private IReservationRepository reservationRepository;
	
	public String deleteReservation(String locator) throws BookingException {
		
		//primero valido que existan las reservas
		reservationRepository.findByLocator(locator)
							 .orElseThrow(()-> new NotFoundException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));
	
		try {
			reservationRepository.deleteByLocator(locator);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		String mensaje = "LOCATOR_DELETED";
		
		return mensaje;
	}
	
	

}
