package com.nt.ston;

public class Printer {
	// create Static reference variable to hold single object reference
	private static Printer INSTANCE;
	
	//private 0-param constructor (To stop prevent object creation from outside
	private Printer() {
		System.out.println("Printer.Printer()::  0-param constructor");
	}
	
	//public static factory method 
	public static Printer getInstance() {
		if(INSTANCE==null)
			INSTANCE=new Printer();
			return INSTANCE;
	}
	
	public void print(String content) {
		System.out.println(content);
	}

}
