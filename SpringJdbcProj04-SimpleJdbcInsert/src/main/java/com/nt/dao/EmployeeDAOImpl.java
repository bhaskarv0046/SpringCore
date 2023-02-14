package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	@Autowired
	private SimpleJdbcInsert sji;//HAS-A-PROPERTY

	//using Map<String,Object>
	/*
	 * @Override public int insert(Employee emp) { // set table name
	 * sji.setTableName("emp"); //create Map object javing col names as values
	 * Map<String,Object> colMap=Map.of("EMPNO",emp.getEmpno(),
	 * "ENAME",emp.getEname(), "desg",emp.getJob(), "sal",emp.getSal(),
	 * "deptno",emp.getDeptno()); int count=sji.execute(colMap); return count; }
	 */
	
	//using MapSqlParameterSource
	/*
	 * @Override public int insert(Employee emp) { // set table name
	 * sji.setTableName("emp"); //use MapSqlParameterSource obj having col names
	 * values MapSqlParameterSource source=new MapSqlParameterSource();
	 * source.addValue("EMPNO",emp.getEmpno());
	 * source.addValue("ENAME",emp.getEname()); source.addValue("JOB",emp.getJob());
	 * source.addValue("SAL",emp.getSal());
	 * source.addValue("DEPTNO",emp.getDeptno()); int count=sji.execute(source);
	 * 
	 * return count; }
	 */
	
	//using BeanPropertySqlParameterSource
	@Override
	public int  insert(Employee emp) {
		//set table name
		sji.setTableName("emp");
		//use BeanPropertySqlParameterSource
		BeanPropertySqlParameterSource source=new BeanPropertySqlParameterSource(emp);
		int count=sji.execute(source);
		return count;
	}

	
	
	

		
}
