package com.spring.aophello.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// An Aspect is a combination of a PointCut and Advice.
@Aspect
@Configuration
public class PerformanceAspect {
	static Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

	@Around(value = "com.spring.aophello.aspects.CommonPointcuts.trackTimeAnnotation()")
	public void totalTimeForCall(ProceedingJoinPoint joinpoint) throws Throwable {
		// Start time
		long startTime = System.currentTimeMillis();

		// then allow method execiton
		joinpoint.proceed();

		// End time
		long endTime = System.currentTimeMillis();

		// calculate elapse.
		// if they are then allow else reject
		logger.info(" Intercepted Method after running - {} : ms: {} ", joinpoint, endTime - startTime);
	}
}
