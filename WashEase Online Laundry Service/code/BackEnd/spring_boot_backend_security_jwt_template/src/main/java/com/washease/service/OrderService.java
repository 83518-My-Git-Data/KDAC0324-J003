package com.washease.service;

import java.util.List;

import com.washease.dto.ApiResponse;
import com.washease.dto.OrderDto;
import com.washease.dto.UserPreviousOrderDto;
import com.washease.dto.UserRequestDto;
import com.washease.entities.Order;
import com.washease.entities.UserPreviousOrder;

public interface OrderService {
	
	List<OrderDto> findOrdersByUserId(Long userId);
    List<UserPreviousOrderDto> getPreviousOrdersByUserId(Long userId);
}
