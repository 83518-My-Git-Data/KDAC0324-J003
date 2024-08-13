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
	
	@Override
    public void registerVendor(VendorDto vendorDto) {
        Vendor vendor = modelMapper.map(vendorDto, Vendor.class);
        vendordao.save(vendor);
    }


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
	    public Vendor updateVendor(Long id, Vendor updatedVendor) {
	        Optional<Vendor> vendorOpt = vendordao.findById(id);
	        if (vendorOpt.isPresent()) {
	            Vendor vendor = vendorOpt.get();
	            vendor.setVendorName(updatedVendor.getVendorName());
	            vendor.setVendorAddress(updatedVendor.getVendorAddress());
	            // Update other fields as necessary
	            return vendordao.save(vendor);
	        }
	        return null;
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


	
	 @Override
	    public void deleteVendor(Long id) {
		 vendordao.deleteById(id);
	    }
	
	 @Override
	    public List<Vendor> getAllVendors() {
	        return vendordao.findAll();
	    }



   
}
