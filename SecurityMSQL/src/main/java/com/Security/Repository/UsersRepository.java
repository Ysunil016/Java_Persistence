package com.Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Security.Model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
