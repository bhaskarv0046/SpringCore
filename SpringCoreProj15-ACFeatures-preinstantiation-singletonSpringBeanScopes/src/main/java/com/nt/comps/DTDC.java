package com.nt.comps;

public class DTDC implements Courier {
	public DTDC() {
		System.out.println("DTDC :: 0-param constructor");
	}

	@Override
	public String deliver(int orderId) {
		return "and OrderID:: "+orderId+" products will be delivered using DTDC courier service";
	}

}
