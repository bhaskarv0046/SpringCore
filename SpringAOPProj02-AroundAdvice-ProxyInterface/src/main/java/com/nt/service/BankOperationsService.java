package com.nt.service;

import org.springframework.stereotype.Service;

@Service("bankService")
public class BankOperationsService implements IBankOperationsService{

	@Override
	public double calcSimpleIntrestAmount(double pamt, double rate, double time) {
		System.out.println("BankOperationsService.calcSimpleIntrestAmount()");
		return pamt*rate*time/100.0;
	}

	@Override
	public double calcCompoundIntrestAmount(double pamt, double rate, double time) {
		System.out.println("BankOperationsService.calcCompoundIntrestAmount()");
		return (pamt*Math.pow(1+rate/100, time))-pamt;
	}
	
}
