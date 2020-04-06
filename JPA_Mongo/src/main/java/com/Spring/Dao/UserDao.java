package com.Spring.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Spring.Modal.UserDetail;

@Repository
public interface UserDao extends MongoRepository<UserDetail, String> {

}
