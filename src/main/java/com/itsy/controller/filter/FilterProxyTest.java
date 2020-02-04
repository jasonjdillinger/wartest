package com.itsy.controller.filter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FilterProxyTest {


	@Pointcut("execution(* com.itsy.controller.filter.SellerFilter.doFilter*(..))")
	public void filterFunctions() {
		
	}
	
	@Before("filterFunctions()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before execution of " + joinPoint.getSignature());
		System.out.println("Before execution of " + joinPoint.getSignature());
		System.out.println("Before execution of " + joinPoint.getSignature());
		System.out.println("Before execution of " + joinPoint.getSignature());
		System.out.println("Before execution of " + joinPoint.getSignature());
		System.out.println("Before execution of " + joinPoint.getSignature());
		System.out.println("Before execution of " + joinPoint.getSignature());
		System.out.println("Before execution of " + joinPoint.getSignature());
		System.out.println("Before execution of " + joinPoint.getSignature());
		System.out.println("Before execution of " + joinPoint.getSignature());
		
	}
	
}
