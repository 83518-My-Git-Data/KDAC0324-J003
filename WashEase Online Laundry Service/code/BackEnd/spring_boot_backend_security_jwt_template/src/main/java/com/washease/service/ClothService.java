package com.washease.service;

import com.washease.dao.ClothDao;
import com.washease.entities.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClothService {

    @Autowired
    private ClothDao clothDao;

    // Get all clothes
    public List<Cloth> getAllClothes() {
        return clothDao.findAll();
    }

    // Get price by cloth ID
    public Double getPriceByClothId(Long clothId) {
        Optional<Cloth> cloth = clothDao.findById(clothId);
        if (cloth.isPresent()) {
            return cloth.get().getPrice();
        } else {
            throw new RuntimeException("Cloth not found with ID: " + clothId);
        }
    }
}
