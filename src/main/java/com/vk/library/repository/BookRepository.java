package com.vk.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.vk.library.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
