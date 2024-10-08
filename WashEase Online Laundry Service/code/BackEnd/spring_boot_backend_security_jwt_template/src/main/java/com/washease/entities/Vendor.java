package com.washease.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id", nullable = false)
    private Long vendorId;

    @Column(nullable = false, unique = true)
    private String vendorName;


 //   @OneToMany
  //  @JoinColumn(name = "order_id", nullable = false)
  //  private List<Order> orders;

//    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<User> users;
  

    @Column(nullable = false)
    private String vendorPhoneNumber;

    private String vendorAddress;

//    private String servicesProvided;

    private String pinCode;
    
    private int rating;

//    @OneToMany(mappedBy = "vendor")
//    private List<Order> orders;
}
