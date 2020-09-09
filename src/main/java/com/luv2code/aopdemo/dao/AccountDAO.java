package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	//add method findAccounts()
	public List<Account> findAccounts(boolean tripWire){
		
		//simulate the exception to check @AfterThrowing
		if(tripWire){
			throw new RuntimeException("No soup for you!!!");
		}
		List<Account> myAccounts = new ArrayList<>();
		
		//create few accounts 
		Account theAccount1 = new Account("Ranjeet","Silver");
		Account theAccount2 = new Account("Suresh","Gold");
		Account theAccount3 = new Account("Mohan","Platinum");
		
		//add them into the myAccounts list
		myAccounts.add(theAccount1);
		myAccounts.add(theAccount2);
		myAccounts.add(theAccount3);
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag){
		System.out.println(getClass()+ " :DOING MY DB WORK : ADDING AN ACCOUNT");
	}
	
	public boolean doWork(){
		System.out.println(getClass()+" : doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+ " in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+ " in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+ " in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ " in setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
