package com.spring.aophello.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {
	@Pointcut("execution(* com.spring.aophello.data.*.*(..))")
	public void dataLayerExecution(){}

	@Pointcut("execution(* com.spring.aophello.business.*.*(..))")
	public void businessLayerExecution(){}

	@Pointcut("com.spring.aophello.aspects.CommonPointcuts.dataLayerExecution() && com.spring.aophello.aspects.CommonPointcuts.businessLayerExecution()")
	public void businessAndDataLayerExecution(){}

	@Pointcut("bean(dao*)")
	public void beanContainingDao(){}

	@Pointcut("@annotation(com.spring.aophello.aspects.TrackTime)")
	public void trackTimeAnnotation(){}
}
