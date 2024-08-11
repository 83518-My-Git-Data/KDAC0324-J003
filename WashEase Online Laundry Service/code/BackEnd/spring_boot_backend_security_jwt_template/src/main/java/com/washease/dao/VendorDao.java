package com.washease.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washease.entities.Vendor;

@Repository
public interface VendorDao extends JpaRepository<Vendor, Long>{

	 List<Vendor> findByPinCode(String pinCode);
	
}
