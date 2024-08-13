package com.washease.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.washease.entities.Address;

public interface AddressDao extends JpaRepository<Address, Long> {

}
