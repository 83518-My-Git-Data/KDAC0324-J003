package com.washease.controllers;

import com.washease.dto.EditUserDto;
import com.washease.dto.UserResponseDto;
import com.washease.entities.User;
import com.washease.entities.Vendor;
import com.washease.service.UserService;
import com.washease.service.VendorService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private ModelMapper mapper;
    

    // Endpoint to delete a vendor by ID
    @DeleteMapping("/deleteVendor/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        try {
            vendorService.deleteVendor(id);
            return ResponseEntity.ok("Vendor deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting vendor: " + e.getMessage());
        }
    }

    // Endpoint to edit a vendor's details
    @PutMapping("/editVendor/{id}")
    public ResponseEntity<Vendor> editVendor(@PathVariable Long id, @RequestBody Vendor updatedVendor) {
        try {
            Vendor vendor = vendorService.updateVendor(id, updatedVendor);
            return ResponseEntity.ok(vendor);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
        }
    }

    // Endpoint to edit a user's details
    @PutMapping("/editUser/{id}")
    public ResponseEntity<UserResponseDto> editUser(@PathVariable Long id, @RequestBody EditUserDto editUserDto) {
        try {
            User updatedUser = userService.updateUser(id, editUserDto);
            UserResponseDto responseDto = mapper.map(updatedUser, UserResponseDto.class);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        try {
            List<UserResponseDto> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();  // Print the full stack trace
            return ResponseEntity.status(500).body(null);
        }
    }


    // Endpoint to get all vendors
    @GetMapping("/getAllVendors")
    public ResponseEntity<List<Vendor>> getAllVendors() {
        try {
            List<Vendor> vendors = vendorService.getAllVendors();
            return ResponseEntity.ok(vendors);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
