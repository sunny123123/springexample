package com.sunny.spring.aop.configuration.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunny.spring.aop.configuration.service.Student;
import com.sunny.spring.aop.service.Customer;

public class Test {
	public static void main(String[] args) {
		//System.out.println(System.getProperty("user.dir"));
		ApplicationContext appContext = new ClassPathXmlApplicationContext("SpringConfiguration-Student.xml");
		Student student = (Student)appContext.getBean("student");
      
     	student.getName();
	}
}
