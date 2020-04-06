package com.Spring.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Dao.UserDao;
import com.Spring.Modal.UserDetail;

@Service
public class UserService_Implementation implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public Optional<UserDetail> findEmployeeByUsername(String username) {
		System.out.println(userDao.findById(username));
		return userDao.findById(username);
	}

	@Override
	public void createUser(UserDetail user) {
		userDao.save(user);
	}

}
