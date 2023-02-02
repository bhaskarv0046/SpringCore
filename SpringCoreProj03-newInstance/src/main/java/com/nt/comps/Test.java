package com.nt.comps;

public class Test {
	private int a,b;
	
	public Test() {
		System.out.println("Test.Test():: 0-param constructor");
	}
	
	public Test(int a,int b) {
		System.out.println("Test.Test():: 2-param constructor ");
		this.a=a;
		this.b=b;
	}

	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + "]";
	}
	
	

}
