package com.nt.aspect;

import java.io.FileWriter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("couponAdvice")
@Aspect
public class DiscountCouponGenerationAdvice {
	@AfterReturning(returning="bamt",
			                                     value="execution(double com.nt.service.ShoppingStore.shopping(..))")
	public void coupon(JoinPoint jp,double bamt) throws Throwable{
		String couponMsg=null;
		if(bamt<=5000)
			couponMsg="Avail 5% discount in the next purchase..";
		else if(bamt<=10000)
			couponMsg="Avail 10% discount in the next purchase..";
		else if(bamt<=15000)
			couponMsg="Avail 15% discount in the next purchase..";
		else 
			couponMsg="Avail 25% discount in the next purchase..";
		//write message to coupon
		FileWriter writer=new FileWriter("e:\\coupon.txt");
		writer.write(couponMsg);
		writer.flush();
		writer.close();
		System.out.println("Coupon Generated....");
	}
}
