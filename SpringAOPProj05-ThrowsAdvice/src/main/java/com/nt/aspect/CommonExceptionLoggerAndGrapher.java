package com.nt.aspect;

import java.io.FileWriter;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nt.Exception.InvalidInputsException;

@Component
@Aspect
public class CommonExceptionLoggerAndGrapher {
	@AfterThrowing(value="execution(java.lang.String com.nt.service.ShoppingStore.shopping(..))",throwing="e")
	public void exceptionLogging_Grapher(JoinPoint jp,Exception e) throws Throwable{
		//ExceptionLogging
		String exceptionMsg=e+" Exception is raised in "+jp.getSignature()+" with args "+Arrays.deepToString(jp.getArgs());
		FileWriter writer=new FileWriter("e:\\expLog.txt",true);
		writer.write(exceptionMsg+"\n");
		writer.flush();
		writer.close();
		//Exception graphing/ translation
		throw new InvalidInputsException(e.getMessage());	//converting raised exception to custom exception	
	}

}
