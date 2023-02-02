package com.nt.comps;

public class BlueDart implements Courier {
	public BlueDart() {
		System.out.println("BlueDart:: 0-param constructor");
	}

	@Override
	public String deliver(int orderId) {		
		return " and OrderId::  "+orderId+"  are set to deliver using BlueDart courier service";
	}

}
