package com.nt.comps;

public class FirstFlight implements Courier {
	public FirstFlight() {
		System.out.println("FirstFlight()  0-param Constructor");
	}

	@Override
	public String deliver(int orderId) {
		// TODO Auto-generated method stub
		return " and OrderId:: "+orderId+" are set to deliver using FristFlight courier service.";
	}

}
