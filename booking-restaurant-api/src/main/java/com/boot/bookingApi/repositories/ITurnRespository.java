package com.boot.bookingApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.bookingApi.entities.Turn;

@Repository
public interface ITurnRespository extends JpaRepository<Turn, Long>{
	
	Optional<Turn> findById(Long id);

}
