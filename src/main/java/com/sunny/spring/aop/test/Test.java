package com.sunny.spring.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunny.spring.aop.service.Customer;

/*
 * Common AspectJ annotations :

	@Before – Run before the method execution
	@After – Run after the method returned a result
	@AfterReturning – Run after the method returned a result, intercept the returned result as well.
	@AfterThrowing – Run after the method throws an exception
	@Around – Run around the method execution, combine all three advices above.
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");
        Customer customer = (Customer)appContext.getBean("customer");
        //customer.addCustomer();
        //customer.addCustomerReturnValue();
      /*  try {
			customer.addCustomerThrowException();
		} catch (Exception e) {
			e.printStackTrace();e
		}*/
        customer.addCustomerAround("sunny");
	}

}
