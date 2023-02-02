package com.nt.comps;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dhl")
@Qualifier("dhl")
public class DHL implements Courier {
	
	public DHL() {
		System.out.println("DHL.DHL()");
	}

	@Override
	public String deliver(int orderId) {
		return "and order Id "+orderId+" will be delivered using DHL courier service";
	}

}
