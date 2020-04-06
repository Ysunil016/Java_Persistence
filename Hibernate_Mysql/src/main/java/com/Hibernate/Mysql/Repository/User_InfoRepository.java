package com.Hibernate.Mysql.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hibernate.Mysql.Bean.User_Info;

public interface User_InfoRepository extends JpaRepository<User_Info, Integer> {

	List<User_Info> findByCity(String city);

	List<User_Info> findByCountry(String country);

}
