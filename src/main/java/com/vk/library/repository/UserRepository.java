package com.vk.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.vk.library.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
}
