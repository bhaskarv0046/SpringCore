package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CitizenVotingEligibilityChecking implements DisposableBean,InitializingBean{
	private String name;
	private int age;
	private String addrs;
	private Date dob;
	
	public CitizenVotingEligibilityChecking() {
		System.out.println("CitizenVotingEligibilityChecking::  0-param Constructor");
	}

	//Setter methods for setter injection
	public void setName(String name) {
		System.out.println("CitizenVotingEligibilityChecking.setName()");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("CitizenVotingEligibilityChecking.setAge()");
		this.age = age;
	}

	public void setAddrs(String addrs) {
		System.out.println("CitizenVotingEligibilityChecking.setAddrs()");
		this.addrs = addrs;
	}
	
	//b method
			public String checkVotingEligibility() {
				System.out.println("CitizenVotingEligibilityChecking.checkVotingEligibility()");
				if(age<18)
					return "Mr/Mrs/Miss::  "+name+"  You are not eligible for voting, verified on  "+dob;
				else
					return "Mr/Mrs?Miss::  "+name+"  You are eligible for Voting ,verified on "+dob;
			}

	@Override
	public void destroy() throws Exception {
		System.out.println("CitizenVotingEligibilityChecking.destroy()");
		// TODO Auto-generated method stub
		name=null;
		age=0;
		addrs=null;
		dob=null;		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("CitizenVotingEligibilityChecking.afterPropertiesSet()");
		//initializing the left over properties
		dob=new Date();
		// verifying the injected value of mandatory properties
		if(name==null || age<0)
			throw new IllegalArgumentException("invalid inputs for name and age");		
	}

	
	
	
	
}
