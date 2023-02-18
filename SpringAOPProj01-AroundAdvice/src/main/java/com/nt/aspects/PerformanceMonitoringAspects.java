package com.nt.aspects;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("pmAspect")
@Aspect
public class PerformanceMonitoringAspects {
	private long start,end;
	
	@Around("execution(double com.nt.service.BankOperationsService.*(..))")
	public Object perofrmance(ProceedingJoinPoint pjp) throws Throwable{
		//pre logics
		start=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+" has entered int b.method at"+new Date());
		//changing b.method arg values
		Object args[]=pjp.getArgs();
		if( (Double)args[0]<=50000)	//Control Point 1
			args[1]=((Double)args[1])-0.5;
		//Controlling the target method execution
		if (((Double)args[0])<=0 || ((Double)args[1])<=0 || ((Double)args[2])<=0)	//control Point 2
			throw new IllegalArgumentException("Invalid argument value");
		//invoke b method/target method
		Object retVal=pjp.proceed();
		//post logics
		end=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+"has exited from b method at"+new Date());
		System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+"has taken "+(end-start)+" ms to complete execution");
		//modifying return value
		retVal=(double)retVal+(double)retVal*0.18;	//Control point 3
	return retVal;
	}
}
