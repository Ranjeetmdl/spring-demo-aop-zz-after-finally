package com.luv2code.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	
	@Before("com.luv2code.aopdemo.aspects.LuvAOPExpression.forDaoPackageExcludeGetterSetter()")
	public void performAPIAnalytics(){
		System.out.println("\n====>Perform API analytics");
	}

}
