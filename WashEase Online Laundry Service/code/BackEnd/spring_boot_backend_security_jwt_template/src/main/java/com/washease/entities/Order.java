package com.washease.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @Column(nullable = false)
    private Date orderDate;

    private Date pickupDate;

    private Date deliveryDate;

    private String orderStatus;

    private Double totalPrice;

//    @OneToOne(mappedBy = "order")
//    private PaymentDetail paymentStatus;

    @OneToOne(mappedBy = "order")
    private PaymentDetail paymentDetails;

    @OneToMany(mappedBy = "orders")
    private List<UserPreviousOrder> userPreviousOrders;
}
