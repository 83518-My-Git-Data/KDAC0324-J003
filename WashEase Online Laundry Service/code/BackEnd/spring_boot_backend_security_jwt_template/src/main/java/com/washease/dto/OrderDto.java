package com.washease.dto;

import java.sql.Date;

import com.washease.entities.PaymentDetail;

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
public class OrderDto {
	private Long orderId;
    private Long userId;

	private Date orderDate;
	private Date pickupDate;

	private Date deliveryDate;

	private String orderStatus;

	private Double totalPrice;
//	private Long paymentDetailsId;

}
