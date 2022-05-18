package com.ramjava.spring.batch.config;



import org.springframework.batch.item.ItemProcessor;

import com.ramjava.spring.batch.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer customer) throws Exception {
		
		return customer;
	}

	
}
