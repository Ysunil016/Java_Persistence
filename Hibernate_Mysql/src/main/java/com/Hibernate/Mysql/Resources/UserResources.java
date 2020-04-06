package com.Hibernate.Mysql.Resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hibernate.Mysql.Bean.User;
import com.Hibernate.Mysql.Repository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserResources {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public Optional<User> getUsersById(@PathVariable("id") String id) {
		return userRepository.findById(id);
	}

	@GetMapping("/findByUsername/{username}")
	public List<User> getUsersByUsername(@PathVariable("username") String username) {
		return userRepository.findByUsername(username);
	}

	@GetMapping("/findByPassword/{password}")
	public List<User> getUsersByPassword(@PathVariable("password") String password) {
		return userRepository.findByPassword(password);
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}

}
