package com.washease.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class AddressDto {
	@NotBlank(message = "Building name is required")
	private String buildingName;

	@NotBlank(message = "Street name is required")
	private String streetName;

	@NotBlank(message = "Area is required")
	private String area;

	@NotBlank(message = "City is required")
	private String city;

	@NotBlank(message = "State is required")
	private String state;

	@NotBlank(message = "Country is required")
	private String country;

	@Pattern(regexp = "\\d{6}", message = "Pin code must be a 6-digit number")
	private String pinCode;
}
