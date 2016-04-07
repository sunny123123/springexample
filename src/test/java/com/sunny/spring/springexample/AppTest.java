package com.sunny.spring.springexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunny.spring.aop.service.Customer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
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
