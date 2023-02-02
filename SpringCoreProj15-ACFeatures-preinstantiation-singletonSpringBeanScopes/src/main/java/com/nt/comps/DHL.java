package com.nt.comps;

public class DHL implements Courier {
	
	public DHL() {
		System.out.println("DHL.DHL()  0-param constructor");
	}

	@Override
	public String deliver(int orderId) {
		return "and OrderId  with "+orderId+" will be delivered using DHL courier service";
	}

}
