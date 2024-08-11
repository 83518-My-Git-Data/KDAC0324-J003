package com.washease.service;

import java.util.List;

import com.washease.dto.OrderDto;
import com.washease.dto.UserRequestDto;
import com.washease.dto.VendorDto;
import com.washease.entities.Vendor;

public interface VendorService {
	public List<VendorDto> getVendorsByPinCode(String pinCode);

	List<OrderDto> getOrdersByVendorId(Long vendorId);

	OrderDto updateOrder(OrderDto orderDto);

	void deleteOrder(Long orderId);
}
