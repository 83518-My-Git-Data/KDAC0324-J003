package com.washease.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.washease.dto.OrderDto;
import com.washease.dto.UserPreviousOrderDto;
import com.washease.service.OrderService;

@RestController
@RequestMapping("/homepage")
public class HomePageController {
    
    @Autowired
    private OrderService oservice;
    
    @GetMapping("/ordersdetails")
    public ResponseEntity<?> getOrderDetails(@RequestParam("userId") Long userId) {
        try {
            List<OrderDto> orders = oservice.findOrdersByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @GetMapping("/previousordersdetails")
    public ResponseEntity<?> getPreviousOrders(@RequestParam("userId") Long userId) {
        try {
            List<UserPreviousOrderDto> previousOrders = oservice.getPreviousOrdersByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(previousOrders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
