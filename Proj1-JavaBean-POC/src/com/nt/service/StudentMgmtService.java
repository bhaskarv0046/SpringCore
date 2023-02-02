//StudentMgmtService  service class
package com.nt.service;

import com.nt.beans.StudentInfo;

public class StudentMgmtService {
	
	public String generateResult(StudentInfo studInfo) {
		//calc total avg
		int total=studInfo.getM1()+studInfo.getM2()+studInfo.getM3();
		float avg=total/3.0f;
		String result = null;
		
		if(studInfo.getM1()<35 || studInfo.getM2()<35 || studInfo.getM3()<35)
			result = "fail";
		else if(avg>=75)
			result="first class with Distinction";
		else if(avg>=60)
			result="First class";
		else if(avg>=50)
			result="Second Class";
		else if(avg>=35)
			result="Third Class";
		else
			result = "Fail";
		
		return "Student "+ studInfo.getSname()+" result is :: "+result;
	}

}
