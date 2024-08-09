package com.washease.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id", nullable = false)
    private Long addressId;
	
    private String BuildingName;

    private String streetName;

    
    private String area;
    private String city;
    private String state;
    
    private String country;
    
    @Column(nullable = false)
    private String pinCode;
    


    

	
}
