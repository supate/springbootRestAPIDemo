package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.springboot.jpa.dao","com.springboot.jpa.controller"})
public class SpringBootHibernateJpaApplication {

	public static void main(String[] args) {
		System.out.println("Inside main method, second change");
		SpringApplication.run(SpringBootHibernateJpaApplication.class, args);
	}
}
