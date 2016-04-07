package com.sunny.spring.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	//@Before("execution(* com.sunny.spring.aop.service.Customer.addCustomer(..))")
	@Before("getNamePointcut()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	/*
	 * 每次都写表达式太麻烦，所以我们可以自已声明一个pointcut，在其他地方直接用就可以了，在上面的@Before后面，我们
	 * 没有写表达式，直接用的Pointcut的名字，更方便一点
	 */
	@Pointcut("execution(* com.sunny.spring.aop.service.Customer.addCustomer(..))")
	    public void getNamePointcut(){
		 System.out.println("we define a pointcut");
	 }
	//Advice arguments, will be applied to bean methods with single String argument
	 @Before("args(name)")
	    public void logStringArguments(String name){
	        System.out.println("String argument passed="+name);
	    }
	@After("execution(* com.sunny.spring.aop.service.Customer.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	@AfterReturning(
		      pointcut = "execution(* com.sunny.spring.aop.service.Customer.addCustomerReturnValue(..))",
		      returning= "result")
		   public void logAfterReturning(JoinPoint joinPoint, Object result) {

			System.out.println("logAfterReturning() is running!");
			System.out.println("hijacked : " + joinPoint.getSignature().getName());
			System.out.println("Method returned value is : " + result);
			System.out.println("******");

		   }
	  @AfterThrowing(
		      pointcut = "execution(* com.sunny.spring.aop.service.Customer.addCustomerThrowException(..))",
		      throwing= "error")
		    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

			System.out.println("logAfterThrowing() is running!");
			System.out.println("hijacked : " + joinPoint.getSignature().getName());
			System.out.println("Exception : " + error);
			System.out.println("******");
		    }
	  
	  @Around("execution(* com.sunny.spring.aop.service.Customer.addCustomerAround(..))")
	   public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
			
		System.out.println("Around before is running!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("Around after is running!");
			
		System.out.println("******");

	   }
}
