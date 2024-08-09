package com.washease.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id", nullable = false)
	private Long cartId;

	@OneToMany
	@JoinColumn(name = "cloth_id", nullable = false)
	private List<ClothType> cloth;

	@OneToMany
	@JoinColumn(name = "material_id", nullable = false)
	private List<ClothMaterial> material;

	private Double price;

	private Long quantity;

	private Double totalPrice;

	@OneToOne
	@JoinColumn(name = "usercart_id", nullable = false)
	private User user;
}
