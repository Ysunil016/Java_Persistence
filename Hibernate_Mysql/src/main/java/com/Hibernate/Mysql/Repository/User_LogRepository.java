package com.Hibernate.Mysql.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Hibernate.Mysql.Bean.User_Log;

public interface User_LogRepository extends JpaRepository<User_Log, Integer> {

	List<User_Log> findByUsername(String username);

	// Using Pageable With Hibernate
	List<User_Log> findByUsername(String username, Pageable pageable);
}
