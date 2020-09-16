package com.vk.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vk.library.model.Reservation;
import com.vk.library.model.User;
import com.vk.library.repository.ReservationRepository;

@Service
@Transactional
public class ReservationService {

	@Autowired
	public ReservationRepository reservationRepository;

	public Reservation addReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	public Reservation updateReservation(Reservation reservationToUpdate) {
		return reservationRepository.save(reservationToUpdate);
	}

	public void deleteReservation(Reservation reservation) {
		reservationRepository.delete(reservation);
	}

	public void deleteReservationById(Long id) {
		reservationRepository.deleteById(id);
	}

	public List<Reservation> getAllReservations() {
		List<Reservation> all = new ArrayList<Reservation>();
		for (Reservation reservation : reservationRepository.findAll()) {
			all.add(reservation);
		}
		return all;
	}

	public Reservation findReservationById(Long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		return reservation.get();
	}
}
