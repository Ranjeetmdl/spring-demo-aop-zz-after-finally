package com.luv2code.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	
	@Before("com.luv2code.aopdemo.aspects.LuvAOPExpression.forDaoPackageExcludeGetterSetter()")
	public void logToCloudAsync(){
		System.out.println("\n====>Logging to cloud in Async Fashion");
	}

}
