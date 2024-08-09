package com.washease.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password; 

    @Column(nullable = false, unique = true)
    private String email;

    
    private String phoneNumber;

    @OneToMany
    private List<Address> addresses= new ArrayList<>();
    
    @Column(nullable = false)
    private Date registrationDate;

    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @OneToMany(mappedBy = "user")
    private List<Order> orders= new ArrayList<>();
    
//	//@JsonIgnore //to tell Jackson , to ignore this field , during ser n de-ser.
//	@OneToMany(mappedBy = "selectedCategory", 
//			cascade = CascadeType.ALL /* ,fetch = FetchType.EAGER */ ,
//			orphanRemoval = true)
//	private List<BlogPost> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserPreviousOrder> previousOrders= new ArrayList<>();
    
    private String resetToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date resetTokenExpiry;
}
