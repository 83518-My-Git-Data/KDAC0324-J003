package com.washease.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserPreviousOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long previousOrderId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order orders;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Date previousOrderDate;

    private Date previousPickupDate;

    private Date previousDeliveryDate;

    private String previousOrderStatus;
}
