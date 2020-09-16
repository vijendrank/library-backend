package com.vk.library.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vk.library.model.User;
import com.vk.library.service.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			LOGGER.info("Adding user...");

			User newUser = userService.addUser(user);
			ResponseEntity<?> response = new ResponseEntity<>(newUser, HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error adding user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody User user) {

		try {
			LOGGER.info("Updating user...");

			User updateUser = userService.updateUser(user);
			ResponseEntity<?> response = new ResponseEntity<>(updateUser, HttpStatus.ACCEPTED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error updating user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestBody User user) {

		try {
			LOGGER.info("Deleting user...");

			userService.deleteUser(user);
			ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.ACCEPTED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {

		try {
			LOGGER.info("Deleting user by id...");

			userService.deleteUserById(id);
			ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.ACCEPTED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting user by id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@RequestMapping(value = "/user/displayAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {

		try {
			LOGGER.info("Getting all users...");

			List<User> users = userService.getAllUsers();
			ResponseEntity<?> response = new ResponseEntity<>(users, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error finding all user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/user/find", method = RequestMethod.GET)
	public ResponseEntity<?> findUser(@RequestParam(name = "email") String email) {

		try {
			LOGGER.info("Find user...");

			User user = userService.findUser(email);
			ResponseEntity<?> response = new ResponseEntity<>(user, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error finding user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}