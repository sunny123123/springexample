package com.sunny.spring.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunny.spring.aop.service.Customer;

public class Test {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");
        Customer customer = (Customer)appContext.getBean("customer");
        customer.addCustomer();
	}

}
