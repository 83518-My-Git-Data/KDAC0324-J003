package com.washease.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.washease.entities.UserPreviousOrder;

public interface PreviousOrderDao extends JpaRepository<UserPreviousOrder, Long>{

	List<UserPreviousOrder> findByUserUserId(Long userId);
}
