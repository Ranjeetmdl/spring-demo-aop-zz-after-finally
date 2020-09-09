package com.luv2code.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAOPExpression {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage(){}
	
	//create pointcut for getter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter(){}
	
	//create pointcut for setter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter(){}
	
	//create pointcut: inclued package....exclued all getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageExcludeGetterSetter(){}

}
