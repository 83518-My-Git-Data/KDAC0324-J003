package com.washease.controllers;

import com.washease.entities.Cloth;
import com.washease.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cloths")
public class ClothController {

    @Autowired
    private ClothService clothService;

    // Endpoint to get all clothes
    @GetMapping
    public ResponseEntity<List<Cloth>> getAllClothes() {
        try {
            List<Cloth> clothes = clothService.getAllClothes();
            return ResponseEntity.ok(clothes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Endpoint to get price by cloth ID
    @GetMapping("/{id}/price")
    public ResponseEntity<Double> getPriceByClothId(@PathVariable Long id) {
        try {
            Double price = clothService.getPriceByClothId(id);
            return ResponseEntity.ok(price);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
