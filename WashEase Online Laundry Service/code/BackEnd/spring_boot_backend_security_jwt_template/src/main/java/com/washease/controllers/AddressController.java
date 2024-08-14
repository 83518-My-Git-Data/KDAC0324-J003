package com.washease.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.washease.dto.AddressDto;
import com.washease.dto.EditAddressDto;
import com.washease.service.AddressService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto) {
        try {
            AddressDto savedAddress = addressService.addAddress(addressDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PutMapping("/update/{addressId}")
    public ResponseEntity<EditAddressDto> updateAddress(@PathVariable("addressId") Long addressId, @RequestBody EditAddressDto addressDto) {
        try {
            EditAddressDto updatedAddress = addressService.updateAddress(addressId, addressDto);
            return ResponseEntity.status(HttpStatus.OK).body(updatedAddress);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/{addressId}")
    public ResponseEntity<EditAddressDto> getAddressById(@PathVariable("addressId") Long addressId) {
        try {
            EditAddressDto addressDto = addressService.getAddressById(addressId);
            return ResponseEntity.status(HttpStatus.OK).body(addressDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        try {
            List<AddressDto> addresses = addressService.getAllAddresses();
            return ResponseEntity.status(HttpStatus.OK).body(addresses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}