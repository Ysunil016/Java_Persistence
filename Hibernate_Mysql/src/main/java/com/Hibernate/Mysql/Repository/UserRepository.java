package com.Hibernate.Mysql.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hibernate.Mysql.Bean.User;

public interface UserRepository extends JpaRepository<User, String> {

	// Finding All Tuples with Username -
	List<User> findByUsername(String username);

	// Finding All Tuples with Password
	List<User> findByPassword(String password);
}
