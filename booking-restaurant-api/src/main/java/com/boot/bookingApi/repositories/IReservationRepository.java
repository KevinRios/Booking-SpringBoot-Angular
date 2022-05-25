package com.boot.bookingApi.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.boot.bookingApi.entities.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {
	
	Optional<Reservation> findById(Long id);
	
	Optional<Reservation> findByLocator(String locator);
	
	@Modifying
	@Transactional
	Optional<Reservation> deleteByLocator(String locator);
	
	Optional<Reservation> findByTurnAndRestaurantId(String turn, Long restaurantId);
	
	

}
