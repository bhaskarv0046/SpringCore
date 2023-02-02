package com.nt.test;

import com.nt.beans.StudentInfo;
import com.nt.service.StudentMgmtService;

public class ClientApp {

	public static void main(String[] args) {
		// prepare javaBean class object
		StudentInfo info = new StudentInfo();
		info.setSno(1001);
		info.setSname("Praveen");
		info.setAddrs("DSNR");
		info.setM1(99);info.setM2(98);info.setM3(98);
		
		//invoke the service method
		StudentMgmtService service = new StudentMgmtService();
		String result=service.generateResult(info);
		System.out.println(result);
		

	}

}
