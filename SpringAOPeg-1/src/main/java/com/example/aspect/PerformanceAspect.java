package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class PerformanceAspect {

	@Around("execution(*com.example.service.OrderService.*(..))")
	public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		
		long end = System.currentTimeMillis();
		long executionTime = end - start;
		
		System.out.println("Performance : " + joinPoint.getSignature().getName()+ " executed in "+executionTime);
		return result;
	}
	
}
