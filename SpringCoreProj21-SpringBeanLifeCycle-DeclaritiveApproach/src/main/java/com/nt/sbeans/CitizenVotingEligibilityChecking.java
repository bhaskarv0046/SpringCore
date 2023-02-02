package com.nt.sbeans;

import java.util.Date;

public class CitizenVotingEligibilityChecking {
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

	//init lifecycle method
	public void myInit() {
		System.out.println("CitizenVotingEligibilityChecking.myInit()");
		//initializing the left over properties
		dob=new Date();
		//verifying the injected values of mandatory properties
		if(name==null || age<0)
			throw new IllegalArgumentException("invalid inputs for age,name");
	}
	
	public void myDestroy() {
		System.out.println("CitizenVotingEligibilityChecking.myDestroy()");
		name=null;
		age=0;
		addrs=null;
		dob=null;
	}
	
	//b method
	public String checkVotingEligibility() {
		System.out.println("CitizenVotingEligibilityChecking.checkVotingEligibility()");
		if(age<18)
			return "Mr/Mrs/Miss::  "+name+"  You are not eligible for voting, verified on  "+dob;
		else
			return "Mr/Mrs?Miss::  "+name+"  You are eligible for Voting ,verified on "+dob;
	}
	
	
}
