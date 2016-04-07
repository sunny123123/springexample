package com.sunny.spring.ioc.beanfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.sunny.spring.ioc.annotation.Student;

@Component
public class AppBean {
	@Bean
	public Student student(){//函数名student相当于xml配置文件Bean的id
		return new Student("panza","male");
	}
}
