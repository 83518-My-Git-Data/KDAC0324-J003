package com.washease.dao;

import com.washease.entities.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothDao extends JpaRepository<Cloth, Long> {
    // No additional methods required as JpaRepository provides basic CRUD operations.
}
