package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("DAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	private static final String GET_EMPS_BY_SALARY_RANGE="SELECT COUNT(*) FROM EMP WHERE SAL>=:min AND SAL<=:max";
	private final static String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(:desg1,:desg2,:desg3) ";
	private static final String INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(:eno,:ename,:desg,:salary,:deptno)";

	@Override
	public int getEmployeesCountBySalaryRange(double start, double end) {
		//
		Map<String,Object> paramsMap=new HashMap();
		paramsMap.put("min",start); paramsMap.put("max",end);
		int count=npjt.queryForObject(GET_EMPS_BY_SALARY_RANGE, paramsMap, Integer.class);		
		return count;
	}

	@Override
	public List<Employee> getEmpDetailsbyDesgs(String desg1, String desg2, String desg3) {
		//use SqlParameterSource implementation class
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("desg1", desg1);
		source.addValue("desg2",desg2);
		source.addValue("desg3", desg3);
		List<Employee> empsList=npjt.query(GET_EMPS_BY_DESG,	//arg1
				                                                    source,								//arg2
				                                                    rs->{	//arg3		//Lambda based anonymous inner class for ResultSetExtractor
				                                                    	List<Employee> list=new ArrayList();
				                                                    	while(rs.next()) {
				                                                    		Employee emp=new Employee();
				                                                    		emp.setEno(rs.getInt(1));
				                                                    		emp.setEname(rs.getString(2));
				                                                    		emp.setDesg(rs.getString(3));
				                                                    		emp.setSalary(rs.getDouble(4));
				                                                    		emp.setDeptno(rs.getInt(5));
				                                                    		list.add(emp);
				                                                    	}
				                                                    	return list;
				                                                    });
		return empsList;
	}

	@Override
	public int insertEmployee(Employee emp) {
		// create BeanPropertySqlParameterSourceobj having Employee cls obj values as named parameter values
		BeanPropertySqlParameterSource source=new BeanPropertySqlParameterSource(emp);
		int count=npjt.update(INSERT_EMPLOYEE, source);
		return count;
	}

}
