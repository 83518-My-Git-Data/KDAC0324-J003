package com.washease.controllers;

import com.washease.dto.UserRequestDto;
import com.washease.dto.OrderDto;
import com.washease.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vendordashboard")
public class VendorDashBoardController {

    @Autowired
    private VendorService vendorService;



    @GetMapping("/orders/{vendorId}")
    public ResponseEntity<List<OrderDto>> getOrdersByVendorId(@PathVariable Long vendorId) {
        List<OrderDto> orders = vendorService.getOrdersByVendorId(vendorId);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @PutMapping("/order")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = vendorService.updateOrder(orderDto);
        if (updatedOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        vendorService.deleteOrder(orderId);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
