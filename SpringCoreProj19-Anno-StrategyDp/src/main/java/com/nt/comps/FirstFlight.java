package com.nt.comps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("fFlight")
public class FirstFlight implements Courier {
	public FirstFlight() {
	  System.out.println("FirstFlight.FirstFlight()");
	}

	@Override
	public String deliver(int orderId) {
		// TODO Auto-generated method stub
		return "and order Id "+orderId+" will be delivered using FirstFlight courier service";
	}

}
