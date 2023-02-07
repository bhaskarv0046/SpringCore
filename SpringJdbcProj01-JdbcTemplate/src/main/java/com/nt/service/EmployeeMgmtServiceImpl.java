package com.nt.service;

import com.nt.dao.IEmployeeDAO;

public class EmployeeMgmtServiceImpl implements IEmployeeService {
	private IEmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
		this.dao=dao;
	}

	@Override
	public int fetchEmpsCount() {
		int count=dao.getEmployeesCount();
		return count;
	}

	@Override
	public String fetchEmpNameByEmpNo(int eno) {
		String name=null;
		return name;
	}

}
