package com.washease.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.washease.dao.OrderDao;
import com.washease.dao.UserDao;
import com.washease.dao.VendorDao;
import com.washease.dto.OrderDto;
import com.washease.dto.UserRequestDto;
import com.washease.dto.VendorDto;
import com.washease.entities.Order;
import com.washease.entities.User;
import com.washease.entities.Vendor;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDao vendordao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDao userDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ModelMapper modelMapper;
	


	public List<VendorDto> getVendorsByPinCode(String pinCode) {
		List<Vendor> vendors = vendordao.findByPinCode(pinCode);
		return vendors.stream().map(vendor -> modelMapper.map(vendor, VendorDto.class)).collect(Collectors.toList());
	}

	
	@Override
	public List<OrderDto> getOrdersByVendorId(Long vendorId) {
		List<Order> orders = orderDao.findByVendorVendorId(vendorId);
		return orders.stream().map(order -> modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
	}




	
	@Override
	public OrderDto updateOrder(OrderDto orderDto) {
	    Order order = modelMapper.map(orderDto, Order.class);

	    // Fetch the user and set it to the order
	    if (orderDto.getUserId() != null) {
	        User user = userDao.findById(orderDto.getUserId())
	                           .orElseThrow(() -> new IllegalArgumentException("User not found"));
	        order.setUser(user);
	    } else {
	        throw new IllegalArgumentException("User ID cannot be null");
	    }

	    Order updatedOrder = orderDao.save(order);
	    return modelMapper.map(updatedOrder, OrderDto.class);
	}


	@Override
	public void deleteOrder(Long orderId) {
		orderDao.deleteById(orderId);
	}


	
	
	

   
}
