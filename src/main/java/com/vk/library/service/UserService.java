package com.vk.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vk.library.model.User;
import com.vk.library.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User userToUpdate) {
		return userRepository.save(userToUpdate);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	public List<User> getAllUsers() {
		List<User> all = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			all.add(user);
		}
		return all;
	}

	public User findUser(String email) {
		return userRepository.findByEmail(email);
	}

	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
}
