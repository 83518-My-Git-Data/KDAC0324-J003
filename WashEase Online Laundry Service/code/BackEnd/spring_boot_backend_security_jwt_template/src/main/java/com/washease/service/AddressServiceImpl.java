package com.washease.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washease.dao.AddressDao;
import com.washease.dto.AddressDto;
import com.washease.dto.EditAddressDto;
import com.washease.entities.Address;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private ModelMapper modelMapper;

    public AddressDto addAddress(AddressDto addressDto) {
        try {
            Address address = modelMapper.map(addressDto, Address.class);
            Address savedAddress = addressDao.save(address);
            return modelMapper.map(savedAddress, AddressDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add address", e);
        }
    }

    @Override
    public EditAddressDto updateAddress(Long addressId, EditAddressDto addressDto) {
        Optional<Address> existingAddress = addressDao.findById(addressId);
        if (existingAddress.isPresent()) {
            Address addressToUpdate = existingAddress.get();
            addressToUpdate.setBuildingName(addressDto.getBuildingName());
            addressToUpdate.setStreetName(addressDto.getStreetName());
            addressToUpdate.setArea(addressDto.getArea());
            addressToUpdate.setCity(addressDto.getCity());
            addressToUpdate.setState(addressDto.getState());
            addressToUpdate.setCountry(addressDto.getCountry());
            addressToUpdate.setPinCode(addressDto.getPinCode());
            Address updatedAddress = addressDao.save(addressToUpdate);
            return modelMapper.map(updatedAddress, EditAddressDto.class);
        } else {
            throw new RuntimeException("Address not found with id: " + addressId);
        }
    }

    @Override
    public EditAddressDto getAddressById(Long addressId) {
        Address address = addressDao.findById(addressId).orElseThrow(() -> new RuntimeException("Address not found with id: " + addressId));
        return modelMapper.map(address, EditAddressDto.class);
    }
    @Override
    public List<AddressDto> getAllAddresses() {
        List<Address> addresses = addressDao.findAll();
        return addresses.stream().map(address -> modelMapper.map(address, AddressDto.class)).collect(Collectors.toList());
    }
}