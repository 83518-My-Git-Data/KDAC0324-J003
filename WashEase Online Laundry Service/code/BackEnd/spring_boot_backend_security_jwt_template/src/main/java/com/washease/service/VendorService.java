package com.washease.service;

import java.util.List;

import com.washease.dto.EditUserDto;
import com.washease.dto.OrderDto;
import com.washease.dto.UserRequestDto;
import com.washease.dto.VendorDto;
import com.washease.entities.Vendor;

public interface VendorService {
	public List<VendorDto> getVendorsByPinCode(String pinCode);

//	List<UserRequestDto> getUsersByVendorId(Long vendorId);

	List<OrderDto> getOrdersByVendorId(Long vendorId);
	List<Vendor> getAllVendors();

//	EditUserDto updateUser(EditUserDto userDto);

	

	OrderDto updateOrder(OrderDto orderDto);

	void deleteOrder(Long orderId);
	
	void deleteVendor(Long id) throws Exception;
    Vendor updateVendor(Long id, Vendor updatedVendor) throws Exception;
    void registerVendor(VendorDto vendorDto);


}
