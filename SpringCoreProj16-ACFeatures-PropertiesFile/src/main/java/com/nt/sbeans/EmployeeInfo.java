package com.nt.sbeans;

public class EmployeeInfo {
	private String empName;
	private int empAge;
	private String empAddrs;
	//to hold os name
	private String os;
	//to hold path env variable
	private String pathData;
	public void setEmpName(String empName) {
		this.empName=empName;		
	}
	public void setEmpAge(int empAge) {
		this.empAge=empAge;
	}
	public void setEmpAddrs(String empAddrs) {
		this.empAddrs=empAddrs;		
	}
	public void setOs(String os) {
		this.os=os;
	}
	public void setPathData(String pathData) {
		this.pathData=pathData;
	}
	@Override
	public String toString() {
		return "EmployeeInfo [empName=" + empName + ", empAge=" + empAge + ", empAddrs=" + empAddrs + ", os=" + os
				+ ", pathData=" + pathData + "]";
	}
	

}
