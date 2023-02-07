package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO{
	//select queries
	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	private static final String GET_EMP_BY_EMPNO="SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_INFO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?) ORDER BY JOB";
	//non-select queries
	private static final String INSERT_EMP_QUERY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
	private static final String UPDATE_BONUS_TO_EMPLOYEES_BY_DESG="UPDATE EMP SET SAL=SAL+? WHERE SAL>=? AND SAL<=?";
	private static final String DELETE_EMPLOYEES_BY_DESG="DELETE FROM EMP WHERE JOB=?";
	
	// injecting  jdbcTemplate
	@Autowired
	private JdbcTemplate jt;
		
	@Override
	public int getEmployeesCount() {
		// TODO Auto-generated method stub
		int count=jt.queryForObject(GET_EMPS_COUNT, Integer.class);//queryForObject();
		return count;
	}

	@Override
	public String getEmpNameByEmpId(int eno) {
		String name=jt.queryForObject(GET_EMP_BY_EMPNO, String.class, eno);
		return name;
	}

	@Override
	public Map<String, Object> getEmployeeByNo(int eno) {
		// TODO Auto-generated method stub
		Map<String,Object> map=jt.queryForMap(GET_EMP_INFO, eno);
		return map;
	}

	@Override
	public List<Map<String, Object>> getEmpDetailsByDesg(String desg1, String desg2) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list=jt.queryForList(GET_EMPS_BY_DESG,desg1,desg2);
		return list;
	}

	@Override
	public int registerEmployee(int eno,String ename,String desg,double salary) {
		int count=jt.update(INSERT_EMP_QUERY,eno,ename,desg,salary);
		return count;
	}

	@Override
	public int addBonusToEmployeesBySalaryRange(double bonusAmt, double startSalary, double endSalary) {
		int count=jt.update(UPDATE_BONUS_TO_EMPLOYEES_BY_DESG, bonusAmt,startSalary,endSalary);
		return count;
	}

	@Override
	public int fireEmployeesByDesg(String desg) {
		int count = jt.update(DELETE_EMPLOYEES_BY_DESG, desg);
		return count;
	}

	
	
}
