package com.vk.library.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vk.library.model.ReturnHistory;
import com.vk.library.service.ReturnHistoryService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class ReturnHistoryController {

	private static final Logger LOGGER = Logger.getLogger(ReturnHistoryController.class.getName());

	@Autowired
	private ReturnHistoryService returnService;

	@RequestMapping(value = "/returnHistory/displayAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAllReservations() {

		try {
			LOGGER.info("Getting all reservations...");

			List<ReturnHistory> returns = returnService.getAllReturnHistory();
			ResponseEntity<?> response = new ResponseEntity<>(returns, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error finding all returns", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}