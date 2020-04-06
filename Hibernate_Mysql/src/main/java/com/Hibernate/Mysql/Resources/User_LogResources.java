package com.Hibernate.Mysql.Resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hibernate.Mysql.Bean.User_Log;
import com.Hibernate.Mysql.Repository.User_LogRepository;

@RestController
@RequestMapping(value = "/user_log")
public class User_LogResources {

	// Not a Good way to Injecting Repository to Resource Class
	@Autowired
	User_LogRepository user_LogRepository;

	@GetMapping("/all")
	public List<User_Log> getAllUser_Logs() {
		return user_LogRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public Optional<User_Log> getUsersById(@PathVariable("id") Integer id) {
		return user_LogRepository.findById(id);
	}

	@GetMapping("/findByUsername/{username}")
	public List<User_Log> getUsersByUsername(@PathVariable("username") String username) {
		return user_LogRepository.findByUsername(username);
	}

	@GetMapping("/findByUsername/{username}/{pageNumber}")
	public List<User_Log> getUsersByUsernameByPage(@PathVariable("username") String username,
			@PathVariable("pageNumber") int pageNumber) {
		return user_LogRepository.findByUsername(username, PageRequest.of(pageNumber, 6, Direction.ASC, "username"));
	}

	@PostMapping("/add")
	public User_Log addUserLogs(@RequestBody User_Log user_log) {
		return user_LogRepository.save(user_log);
	}
}
