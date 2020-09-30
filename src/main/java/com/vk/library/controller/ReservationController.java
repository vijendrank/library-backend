package com.vk.library.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vk.library.model.Book;
import com.vk.library.model.Reservation;
import com.vk.library.model.ReservationRequest;
import com.vk.library.model.ReturnHistory;
import com.vk.library.model.User;
import com.vk.library.service.BookService;
import com.vk.library.service.ReservationService;
import com.vk.library.service.ReturnHistoryService;
import com.vk.library.service.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class ReservationController {

	private static final Logger LOGGER = Logger.getLogger(ReservationController.class.getName());

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ReturnHistoryService returnHistoryService;

	@RequestMapping(value = "/reservation/create", method = RequestMethod.POST)
	public ResponseEntity<?> createReservation(@RequestBody ReservationRequest reservationRequest) {
		try {
			LOGGER.info("Create reservation...");

			User user = userService.findUserById(reservationRequest.getUserId());
			Book book = bookService.findBookById(reservationRequest.getBookId());

			Reservation reservation = new Reservation();
			reservation.setBook(book);
			reservation.setUser(user);
			reservation.setReserveCount(1);

			LocalDate today = LocalDate.now();
			Date reserveDate = Date.valueOf(today);
			Date returnDate = Date.valueOf(today.plusDays(14));

			reservation.setReserveDate(reserveDate);
			reservation.setReturnDate(returnDate);

			Reservation newReservation = reservationService.addReservation(reservation);
			LOGGER.info("Creating reservation newReservation: " + newReservation);

			ResponseEntity<?> response = new ResponseEntity<>(newReservation, HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error creating reservation", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/reservation/renew", method = RequestMethod.PUT)
	public ResponseEntity<?> renewReservation(@RequestBody ReservationRequest reservationRequest) {

		try {
			LOGGER.info("Renew reservation...");

			Reservation reservation = reservationService.findReservationById(reservationRequest.getReservationId());

			LocalDate today = LocalDate.now();
			Date reserveDate = Date.valueOf(today);
			Date returnDate = Date.valueOf(today.plusDays(14));

			reservation.setReserveDate(reserveDate);
			reservation.setReturnDate(returnDate);

			Integer oldReserveCount = reservation.getReserveCount();
			if (oldReserveCount >= 3) {
				return new ResponseEntity<>("Cannot renew reservation after 3 time", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			reservation.setReserveCount(oldReserveCount + 1);

			Reservation reservationToRenew = reservationService.updateReservation(reservation);
			ResponseEntity<?> response = new ResponseEntity<>(reservationToRenew, HttpStatus.ACCEPTED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error renewing reservation", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Return book by deleting the record and saving the history in the RETURN_HISTORY table
	@RequestMapping(value = "/reservation/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteReservation(@PathVariable Long id) {

		try {
			LOGGER.info("Deleting reservation by id...");
			
			//1. get the reservation by using the id
			Reservation reservation = reservationService.findReservationById(id);
			
			//2. save the details in the RETURN_HISTORY table
			ReturnHistory returnHistory = new ReturnHistory();
			returnHistory.setBook(reservation.getBook());
			returnHistory.setUser(reservation.getUser());
			returnHistory.setReturnDate(reservation.getReturnDate());
			returnHistoryService.addReturnHistory(returnHistory);
			
			//3. delete the reservation record
			reservationService.deleteReservationById(id);
			
			ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.ACCEPTED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting reservation by id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/reservation/displayAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAllReservations() {

		try {
			LOGGER.info("Getting all reservations...");

			List<Reservation> reservations = reservationService.getAllReservations();
			ResponseEntity<?> response = new ResponseEntity<>(reservations, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error finding all reservations", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}