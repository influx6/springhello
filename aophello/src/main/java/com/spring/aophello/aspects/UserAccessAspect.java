package com.spring.aophello.aspects;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

// An Aspect is a combination of a PointCut and Advice.
@Aspect
@Configuration
public class UserAccessAspect {
	static Logger logger = LoggerFactory.getLogger(UserAccessAspect.class);

	// Whatever we do here is called: Weaving (i.e, the function before with it's PointCut and Advice.
	// Whilst the Framework we use (currently org.aspectj) is called the Weaver.

	// What kind of method calls I would intercept -> this are called PointCuts
	// that is point of areas where we want to intercept.
	@Before(value = "execution(* com.spring.aophello.data.*.*(..))")
	public void before(JoinPoint joinpoint) {
		// JoinPoint is a specific interception of an execution.

		// These are called: Advice
		// So we:
		// Check if user has access right
		// if they are then allow else reject
		logger.info(" Intercepted Method Calls - {}", joinpoint);
	}

	@After(value = "execution(* com.spring.aophello.data.*.*(..))")
	public void afterCall(JoinPoint joinpoint) {
		// JoinPoint is a specific interception of an execution.

		// These are called: Advice
		// So we:
		// Check if user has access right
		// if they are then allow else reject
		logger.info(" Intercepted Method after running - {}", joinpoint);
	}

	@AfterReturning(value = "execution(* com.spring.aophello.data.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinpoint, Object result) {
		// JoinPoint is a specific interception of an execution.

		// These are called: Advice
		// So we:
		// Check if user has access right
		// if they are then allow else reject
		logger.info(" Intercepted Method after returning - {} : {}", joinpoint, result);
	}

	@AfterThrowing(value = "execution(* com.spring.aophello.data.*.*(..))", throwing = "exception")
	public void afterThrowing(JoinPoint joinpoint, Exception exception) {
		// JoinPoint is a specific interception of an execution.

		// These are called: Advice
		// So we:
		// Check if user has access right
		// if they are then allow else reject
		logger.info(" Intercepted Method after throwing error - {} : {}", joinpoint, exception);
	}
}
