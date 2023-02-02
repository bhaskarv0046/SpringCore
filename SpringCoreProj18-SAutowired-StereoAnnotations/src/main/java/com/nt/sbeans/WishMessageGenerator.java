package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

public class WishMessageGenerator {
	//private date Has-a-property
	@Autowired // FiledInjection	
	private Date date; 		//matching bean Id in cfg and Autowired property
	
	@Autowired  //Setter injection
	@Qualifier("dt3")
	//@Primary
	public void setDate(Date date) {
		System.out.println("WishMessageGenerator.setDate() ");
		this.date=date;
	}
	
	@Autowired  //Constructor Injection
	public WishMessageGenerator(@Qualifier("dt1")Date date) {
	  System.out.println("WishMessageGenerator  Parametirized Constructor");
	  this.date=date; }
	 
	
	@Autowired   //arbitrary method injection
	@Qualifier("dt4")
	public void assign(Date date) {
		System.out.println("WishMessageGenerator.assign()");
		this.date=date;
	}
	
	public String showWishMessage(String user) {
		//get current hour of the day
		int hour=date.getHours();
		//generate message
		if(hour<12)
			return "Good Morning:: "+user;
		else if(hour<16)
			return "Good Afternoon::"+user;
		else if(hour<20)
			return "Good Evening  "+user;
		else
			return "Good Night "+user;		
	}

}
