package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String streetName;
	@Column(name = "keen_city")
	private String city;
	
	
	@JoinColumn(name="customer_id_fk")
	@OneToOne
	private Customer customer;
	
	public Address(String streetName, String city) {
		super();
		this.streetName = streetName;
		this.city = city;
	}
	
	

}
