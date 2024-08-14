package com.washease.controllers;

import com.washease.dto.VendorDto;
import com.washease.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;
    
    // Vendor Registration
    @PostMapping("/register")
    public ResponseEntity<String> registerVendor(@RequestBody VendorDto vendorDto) {
        try {
            vendorService.registerVendor(vendorDto);
            return ResponseEntity.ok("Vendor registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error registering vendor: " + e.getMessage());
        }
    }

    @GetMapping("/getvendors")
    public List<VendorDto> getVendorsByPinCode(@RequestParam String pinCode) {
        return vendorService.getVendorsByPinCode(pinCode);
    }
}
