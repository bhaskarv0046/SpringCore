package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeMgmtDAOImpl implements IEmployeeDAO {
	@Autowired
	private SimpleJdbcCall sjc;

	@Override
	public String authenticate(String username, String password) {
		// Specify procedure name
		sjc.setProcedureName("SPRING_AUTHENTICATION");
		Map<String,Object> inParams=Map.of("USERNAME",username,"PASSWORD",password);
		Map<String,Object> outParams=sjc.execute(inParams);
		
		return (String)outParams.get("RESULT");
	}

}
