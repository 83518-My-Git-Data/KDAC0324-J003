package com.washease.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.washease.entities.Order;
import com.washease.entities.User;

public interface UserDao extends JpaRepository<User, Long>{
//	Optional<User> findByorderId(User uid);
	Optional<User> findByEmailAndPassword(String email,String pass);
	Optional<User> findByEmail(String email);

}
