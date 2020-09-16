package com.vk.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.vk.library.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
