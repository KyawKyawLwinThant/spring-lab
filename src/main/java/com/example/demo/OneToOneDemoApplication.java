package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.CustomerService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneDemoApplication {
	private final CustomerService customerService;
	
	
	@Bean
	public ApplicationRunner runner() {
		return r ->{
			customerService.createDb();
			JPAUtil.checkData("select * from customer");
			JPAUtil.checkData("select * from address");
		};
	}

	public static void main(String[] args) {
		
		SpringApplication.run(OneToOneDemoApplication.class, args);
	}

}
