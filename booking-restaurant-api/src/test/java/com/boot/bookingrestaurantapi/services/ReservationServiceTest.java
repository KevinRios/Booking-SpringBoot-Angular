package com.boot.bookingrestaurantapi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.bookingrestaurantapi.entities.Board;
import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.entities.Turn;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.CreateReservationRest;
import com.boot.bookingrestaurantapi.repositories.ReservationRepository;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.repositories.TurnRepository;
import com.boot.bookingrestaurantapi.services.impl.ReservationServiceImpl;

public class ReservationServiceTest {

	private static final Date DATE = new Date();
	private static final Long PERSON = 30L;
	private static final Long RESTAURANT_ID = 5L;
	private static final Long TURN_ID = 5L;

	private static final String NAME = "Hamburguesas";
	private static final String DESCRIPTION = "Mucha comida";
	private static final String ADRESS = "Calle calle";
	private static final String IMAGE = "WWW.IMAGEN.COM";

	CreateReservationRest CREATE_RESERVATION_REST = new CreateReservationRest();
	private static final Restaurant RESTAURANT = new Restaurant();
	private static final Turn TURN = new Turn();

	private static final List<Turn> TURN_LIST = new ArrayList<>();

	private static final Optional<Restaurant> OPTIONAL_RESTAURANT = Optional.of(RESTAURANT);
	private static final Optional<Turn> OPTIONAL_TURN = Optional.of(TURN);

	@Mock
	private RestaurantRepository restaurantRepository;
	@Mock
	private TurnRepository turnRepository;
	@Mock
	private ReservationRepository reservationRepository;

	@InjectMocks
	private ReservationServiceImpl reservationServiceImpl;

	@Before
	public void init() throws BookingException {
		MockitoAnnotations.initMocks(this);

		TURN.setId(TURN_ID);
		TURN.setName(NAME);
		TURN.setRestaurant(RESTAURANT);

		RESTAURANT.setId(RESTAURANT_ID);
		RESTAURANT.setName(NAME);
		RESTAURANT.setDescription(DESCRIPTION);
		RESTAURANT.setAdress(ADRESS);
		RESTAURANT.setImage(IMAGE);
		RESTAURANT.setTurns(TURN_LIST);

		CREATE_RESERVATION_REST.setDate(DATE);
		CREATE_RESERVATION_REST.setPerson(PERSON);
		CREATE_RESERVATION_REST.setRestaurantId(RESTAURANT_ID);
		CREATE_RESERVATION_REST.setTurnId(TURN_ID);
	}

	@Test
	public void createReservationTest() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
		Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN);
		//Mockito.when(reservationRepository.findByTurnAndRestaurantId(TURN.getName(), RESTAURANT.getId())).thenReturn(OPTIONAL_RESERVATION);


		reservationServiceImpl.createReservation(CREATE_RESERVATION_REST);
	}

}
