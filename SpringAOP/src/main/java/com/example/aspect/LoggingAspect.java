package com.example.aspect;

import java.time.LocalTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	
	@Before("execution(* com.example.service.ProductService.*(..))")
	public void logBefore() {
		
		System.out.println("AOP method is about to execute");
		
	}
	
	@After("execution(* com.example.service.ProductService.*(..))")
	public void logAfter() {
		
		System.out.println("AOP After is about to execute");
		
	}
	
	@AfterReturning(pointcut = "execution"
			+"(* com.example.service.ProductService.*(..))",
returning = "result")
	public void afterReturningAdvice(Object result) {
		System.out.println("After returning "+ result);
	}
	
	@AfterThrowing(
	        pointcut = "execution(* com.example.service.ProductService.*(..))",
	        throwing = "ex"
	)
	public void afterThrowingAdvice(Throwable ex) {

	    System.out.println("AOP After Throwing: " + ex.getMessage());

	}
		
	@Around("execution(* com.example.service.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Around before part executed" + LocalTime.now());
		
		Object result = joinPoint.proceed();
		
		System.out.println("Around after part executed" +
		LocalTime.now());
		return result;
		
	}

}