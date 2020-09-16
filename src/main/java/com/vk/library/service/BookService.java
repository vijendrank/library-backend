package com.vk.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vk.library.model.Book;
import com.vk.library.repository.BookRepository;

@Service
@Transactional
public class BookService {

	@Autowired
	public BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public Book updateBook(Book bookToUpdate) {
		return bookRepository.save(bookToUpdate);
	}

	public void deleteUser(Book book) {
		bookRepository.delete(book);
	}

	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
	}

	public List<Book> getAllBooks() {
		List<Book> all = new ArrayList<Book>();
		for (Book book : bookRepository.findAll()) {
			all.add(book);
		}
		return all;
	}

	public Book findBookById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		return book.get();
	}
}
