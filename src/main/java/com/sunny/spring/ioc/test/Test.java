package com.sunny.spring.ioc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunny.spring.ioc.annotation.Student;
import com.sunny.spring.ioc.annotation.StudentService;

public class Test {
	public static void main(String[] args) {
		fun1();
	}
	public static void fun1(){
		//can load lots of configuration files
		ApplicationContext appContenxt = new ClassPathXmlApplicationContext(new String[]{"SpringIOC-Student.xml"});
		
		Student student = (Student)appContenxt.getBean("student");
		
		StudentService studentService = (StudentService)appContenxt.getBean("studentService");
		
		studentService.getStudent();
		System.out.println(student);
	}
}
