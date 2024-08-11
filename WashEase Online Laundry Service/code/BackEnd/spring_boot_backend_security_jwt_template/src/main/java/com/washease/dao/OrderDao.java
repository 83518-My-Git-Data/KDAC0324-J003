package com.washease.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.washease.entities.Order;
import com.washease.entities.User;
import com.washease.entities.UserPreviousOrder;

public interface OrderDao extends JpaRepository<Order, Long>{
	
	List<Order> findByUserUserId(Long userId);
	List<Order> findByVendorVendorId(Long vendorId);
}
