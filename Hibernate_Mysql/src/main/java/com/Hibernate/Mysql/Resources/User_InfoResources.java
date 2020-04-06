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
import com.Hibernate.Mysql.Bean.User_Info;
import com.Hibernate.Mysql.Repository.User_InfoRepository;

@RestController
@RequestMapping(value = "/user_info")
public class User_InfoResources {

	@Autowired
	User_InfoRepository user_InfoRepository;

	@GetMapping("/all")
	public List<User_Info> getAllUsers() {
		return user_InfoRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public Optional<User_Info> getUsersById(@PathVariable("id") Integer id) {
		return user_InfoRepository.findById(id);
	}

	@GetMapping("/findByCity/{city}")
	public List<User_Info> getUsersByUsername(@PathVariable("city") String city) {
		return user_InfoRepository.findByCity(city);
	}

	@GetMapping("/findByCountry/{country}")
	public List<User_Info> getUsersByPassword(@PathVariable("country") String country) {
		return user_InfoRepository.findByCountry(country);
	}

	@PostMapping("/add")
	public User_Info addUser(@RequestBody User_Info user_info) {
		return user_InfoRepository.save(user_info);
	}

}
