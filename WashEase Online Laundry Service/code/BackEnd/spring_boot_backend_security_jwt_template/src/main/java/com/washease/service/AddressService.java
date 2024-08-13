package com.washease.service;

import java.util.List;

import com.washease.dto.AddressDto;
import com.washease.dto.EditAddressDto;
import com.washease.entities.Address;
public interface AddressService {
    AddressDto addAddress(AddressDto addressDto);
    EditAddressDto updateAddress(Long addressId, EditAddressDto addressDto);
   
    EditAddressDto getAddressById(Long addressId);
    List<AddressDto> getAllAddresses();
}