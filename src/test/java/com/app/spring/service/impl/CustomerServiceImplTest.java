package com.app.spring.service.impl;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.spring.model.Customer;
import com.app.spring.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/servlet-context-test.xml"})
@Transactional
public class CustomerServiceImplTest {

	@Autowired
	CustomerService customerService;
	
	@Test
	public void test() {
		Customer customer = new Customer();
		customer.setName("Test");
		customer.setAddress("Servicetest");
		customerService.addCustomer(customer);
	}

}
