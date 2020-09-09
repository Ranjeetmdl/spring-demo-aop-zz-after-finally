package com.luv2code.aopdemo.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspects {
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
		
		//print out on which method, we are advising on
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>Executing @After (finally) advise on method :"+theMethod);
		
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			       throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc){
		
		//print out on which method, we are advising on
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>Executing @AfterThrowing advise on method :"+theMethod);
		
		//log the exception
		System.out.println("\n=========>exception is :"+theExc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result){
		
		//print out on which method, we are advising on
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>Executing @AfterReturning advise on method :"+theMethod);
		
		//print the result of method call
		System.out.println("\n=========>result is :"+result);
		
		//let's post-process the data....let's modify it
		
		//convert the name to upper-case
		convertNamesToUpperCase(result);
		
		System.out.println("\n=========>result is :"+result);
		
	}
	
	private void convertNamesToUpperCase(List<Account> result) {
		// loop through the result
		for(Account theAccount: result){
		//get the upper-case version of name
		String upperName = theAccount.getName().toUpperCase();
		
		//update the account
		theAccount.setName(upperName);
		}
	}

	@Before("com.luv2code.aopdemo.aspects.LuvAOPExpression.forDaoPackageExcludeGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
		System.out.println("\n====>Executing @Before advice on method()");
		
		//display the method signature
		MethodSignature methodSign = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method :"+methodSign);
		
		//display the method parameters
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg : args){
			System.out.println(tempArg);
			
			if(tempArg instanceof Account){
				//downcast and print account specific info
				Account theAccount=(Account) tempArg;
				System.out.println("Account Name :"+theAccount.getName());
				System.out.println("Account Level :"+theAccount.getLevel());
			}
		}
	}
	
}
