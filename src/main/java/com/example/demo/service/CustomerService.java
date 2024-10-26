package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	private final AddressRepository addressRepository;
	
	
	@Transactional
	public void createDb() {
		Customer customer1=new Customer("John Doe", "john@gmail.com");
		Customer customer2=new Customer("John William", "william@gmail.com");
		
		Address address1=new Address("Dream Land", "Dream City");
		Address address2=new Address("72 Park Avenue", "Keen City");
		
		address1.setCustomer(customer2);
		customer2.setAddress(address1);
		address2.setCustomer(customer1);
		customer1.setAddress(address2);
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		addressRepository.save(address1);
		addressRepository.save(address2);
		
	}

}
