package com.washease.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VendorDto {

	private String vendorName;

	private String vendorPhoneNumber;

	private String vendorAddress;

//	    private String servicesProvided;

	private String pinCode;

	private int rating;
}
