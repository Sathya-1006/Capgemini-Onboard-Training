package com.example.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
	
	@Around("execution(* com.example.service.OrderService.*(..))")
	public Object logMethod(ProceedingJoinPoint joinPoint)  throws Throwable{
		String className = joinPoint.getTarget().getClass().getSimpleName();
		
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		
		System.out.println("Start : "+className+ "\t" + methodName);
		System.out.println("Arguments :"+ Arrays.toString(arguments));
		
		Object result = joinPoint.proceed();
		System.out.println("End : "+ className + "\t" + methodName);
		return result;
		
		
	}
}
