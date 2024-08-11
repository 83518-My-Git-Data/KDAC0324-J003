package com.washease.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washease.dao.OrderDao;
import com.washease.dao.PreviousOrderDao;
import com.washease.entities.Order;
import com.washease.entities.UserPreviousOrder;
import com.washease.dto.OrderDto;
import com.washease.dto.UserPreviousOrderDto;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderDao odao;
    
    @Autowired
    private PreviousOrderDao pvodao;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrderDto> findOrdersByUserId(Long userId) {
        List<Order> orders = odao.findByUserUserId(userId);
        return orders.stream()
                     .map(order -> modelMapper.map(order, OrderDto.class))
                     .collect(Collectors.toList());
    }

    @Override
    public List<UserPreviousOrderDto> getPreviousOrdersByUserId(Long userId) {
        List<UserPreviousOrder> previousOrders = pvodao.findByUserUserId(userId);
        return previousOrders.stream()
                             .map(order -> modelMapper.map(order, UserPreviousOrderDto.class))
                             .collect(Collectors.toList());
    }
}
