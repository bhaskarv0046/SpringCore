package com.nt.comps;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dtdc")
@Lazy
public class DTDC implements Courier {
	
	public DTDC() {
		System.out.println("DTDC.DTDC()");
	}

	@Override
	public String deliver(int orderId) {
		return "and order Id "+orderId+" will be delivered using DTDC courier service";
	}

}
