package com.nt.service;

public interface IBankOperationsService {
	public double calcSimpleIntrestAmount(double pamt,double rate,double time);
	public double calcCompoundIntrestAmount(double pamt,double rate,double time);
}
