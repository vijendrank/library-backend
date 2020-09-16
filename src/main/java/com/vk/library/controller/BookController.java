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
import org.springframework.web.bind.annotation.RestController;

import com.vk.library.model.Book;
import com.vk.library.service.BookService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class BookController {

	private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public ResponseEntity<?> addBook(@RequestBody Book book) {
		try {

			LOGGER.info("Adding book...");

			Book newBook = bookService.addBook(book);
			ResponseEntity<?> response = new ResponseEntity<>(newBook, HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error adding book", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/book/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBook(@RequestBody Book book) {

		try {
			LOGGER.info("Updating book...");

			Book updateBook = bookService.updateBook(book);
			ResponseEntity<?> response = new ResponseEntity<>(updateBook, HttpStatus.ACCEPTED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error updating book", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/book/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBook(@RequestBody Book book) {

		try {
			LOGGER.info("Deleting book...");

			bookService.deleteUser(book);
			ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.ACCEPTED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting book", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/book/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBook(@PathVariable Long id) {

		try {
			LOGGER.info("Deleting book by id...");

			bookService.deleteBookById(id);
			ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.ACCEPTED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting book by id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/book/displayAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAllBook() {

		try {
			LOGGER.info("Getting all books...");

			List<Book> books = bookService.getAllBooks();
			ResponseEntity<?> response = new ResponseEntity<>(books, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>("Error finding all book", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}