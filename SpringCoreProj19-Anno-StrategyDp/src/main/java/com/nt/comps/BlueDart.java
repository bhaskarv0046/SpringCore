package com.nt.comps;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bdart")
@Scope("singleton")
@Primary
public class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart.BlueDart()");
	}

	@Override
	public String deliver(int orderId) {
		// TODO Auto-generated method stub
		return "and order Id "+orderId+" will be delivered using BlueDart courier service";
	}

}
