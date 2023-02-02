package com.nt.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WishMessageGenerator;

public class JavaConfigApproachTest {

	public static void main(String[] args) {
		// create IOC container by taking AppConfig class as argument value
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		//get target sb class object
		WishMessageGenerator generator = ctx.getBean("wmg",WishMessageGenerator.class);
		//class b method
		String resultMsg=generator.showWishMessage("McDonald Murthy");
		System.out.println(resultMsg);
		
		//close the container
		ctx.close();

	}

}
