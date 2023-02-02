package com.nt.sbeans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("citizen")
@PropertySource("com/nt/commons/Info.properties")
public class CitizenVotingEligibilityChecking {
	@Value("${citizen.name}")
	private String name;
	@Value("${citizen.age}")
	private int age;
	@Value("${citizen.addrs}")
	private String addrs;
	private Date dob;
	
	public CitizenVotingEligibilityChecking() {
		System.out.println("CitizenVotingEligibilityChecking::  0-param Constructor");
	}

	
	//init lifecycle method
	@PostConstruct
	public void myInit() {
		System.out.println("CitizenVotingEligibilityChecking.myInit()");
		//initializing the left over properties
		dob=new Date();
		//verifying the injected values of mandatory properties
		if(name==null || age<0)
			throw new IllegalArgumentException("invalid inputs for age,name");
	}
	
	@PreDestroy
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
