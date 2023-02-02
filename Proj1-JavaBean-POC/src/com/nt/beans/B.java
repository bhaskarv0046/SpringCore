// Example for StrategyPattern rule2 CODE USING COMPOSITION
package com.nt.beans;

public class B {
	private A a = new A();
	
	public int m1() {
		int val=Math.round(a.m1());
		return val;
	}
	
	public static void main(String args[]) {
		B b=new B();
		System.out.println(b.m1());
	}
	

}
