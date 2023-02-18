package com.nt.aspect;

import java.util.Scanner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ScocietyEntryApprovalAdvice {
	@Before("execution(java.lang.String com.nt.service.ResidentOperationsService.*(..))")
	public void approveForEntry(JoinPoint jp) throws Throwable{
		System.out.println("ScocietyEntryApprovalAdvice.approveForEntry()");
		String guestName=(String)jp.getArgs()[0];
		System.out.println(guestName+" guest wants to take entry to your flat do you want to Approve?(Yes/No)");
		Scanner sc=new Scanner(System.in);
		String reply=sc.next();
		if (reply.equalsIgnoreCase("no"))
			throw new IllegalArgumentException("Entry not approved by the Flat Owner");
	}
}
