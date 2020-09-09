package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		// read the java config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call the findAccounts()
		List<Account> theAccounts = null;
		
		try {
			//add a boolean flag to simulate the exception
			boolean tripWire=false;
			theAccounts=theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\nMain Program...caught exception : "+e);
		}
		
		//display the list of accounts
		System.out.println("\n\nMain Program : AfterFinallyDemoApp");
		System.out.println("------------------------------");
		System.out.println(theAccounts);
		
		//close the context
		context.close();

	}

}
