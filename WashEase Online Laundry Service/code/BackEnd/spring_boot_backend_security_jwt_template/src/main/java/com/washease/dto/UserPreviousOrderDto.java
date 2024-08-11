package com.washease.dto;

import java.sql.Date;

import com.washease.entities.Order;
import com.washease.entities.User;

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
public class UserPreviousOrderDto {
    private Long previousOrderId;
//    private Order orders;
//    private User user;
    private Date previousOrderDate;
    private Date previousPickupDate;

    private Date previousDeliveryDate;

    private String previousOrderStatus;
   }
