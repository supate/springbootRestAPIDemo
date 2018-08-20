package com.springboot.jpa.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateDataConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	@Bean
	public SessionFactory getSessionFactory() {
		System.out.println("entityManagerFactory " + getEntityManagerFactory());
		if(entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("entityManagerFactory is null");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}


	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
}
