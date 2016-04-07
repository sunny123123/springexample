package com.sunny.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {
	//@Autowired
	private Student student;
	
	public  void  getStudent(){
		System.out.println(student.toString());
	}
	/*
	 * @Autowired 修饰函数时候，当调用getBean()获得实例的时候就会自动注入所需对象
	 */
	@Autowired
	public void setStudent(Student student) {
		this.student = student;
	}
}
