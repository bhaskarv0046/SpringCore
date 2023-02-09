package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	@Autowired
	private JdbcTemplate jt;//HAS-A-PROPERTY
	
	private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?) ORDER BY JOB";

	@Override
	public Employee getEmployeeByNo(int no) {
		Employee e=jt.queryForObject(GET_EMP_BY_NO, 				//ARG1
				                                               (rs,rowno)->{	//using Lamba Expression
				                                            	   Employee emp=new Employee();
				                                            	   emp.setEno(rs.getInt(1));
				                                            	   emp.setEname(rs.getString(2));
				                                            	   emp.setDesg(rs.getString(3));
				                                            	   emp.setSalary(rs.getDouble(4));
				                                            	  emp.setDeptno(rs.getInt(5)); 
				                                            	  return emp; 
				                	 				                 },				//ARG2
				                                               no);				//ARG3
		return e;
	}

		

	/*
	 * @Override public Employee getEmployeeByNo(int no) {
	 * System.out.println("EmployeeDAOImpl.getEmployeeByNo()"); //Anonymous Inner
	 * class Employee emp=jt.queryForObject(GET_EMP_BY_NO, new RowMapper<Employee>()
	 * {
	 * 
	 * @Override public Employee mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { // Copy RS obj record to Employee cls obj Employee emp=new
	 * Employee(); emp.setEno(rs.getInt(1)); emp.setEname(rs.getString(2));
	 * emp.setDesg(rs.getString(3)); emp.setSalary(rs.getDouble(4));
	 * emp.setDeptno(rs.getInt(5)); return emp; } }, no); return emp; }
	 */	
	
	//inner class 
	/*
	 * private static class EmployeeMapper implements RowMapper<Employee>{
	 * 
	 * @Override public Employee mapRow(ResultSet rs, int rowNum) throws
	 * SQLException {
	 * System.out.println("EmployeeDAOImpl.EmployeeMapper.mapRow(-,-)");
	 * System.out.println("Record number :: "+rowNum); //copy RS object record to
	 * Employee cls obj Employee emp=new Employee(); emp.setEno(rs.getInt(1));
	 * emp.setEname(rs.getString(2)); emp.setDesg(rs.getString(3));
	 * emp.setSalary(rs.getDouble(4)); emp.setDeptno(rs.getInt(5)); return emp;
	 * }//method
	 * 
	 * }//inner class
	 */
	
	
	//Lambda based
	@Override
	public List<Employee> getEmployeesByDesg(String desg1, String desg2) {
		List<Employee> empList=jt.query(GET_EMPS_BY_DESG,	//Arg1
				                                               rs->{
				                                            	   List<Employee> list=new ArrayList();	//arg2
				                                            	   while(rs.next()) {
				                                            		   Employee emp = new Employee();
				                                            		   emp.setEno(rs.getInt(1));
				                                            		   emp.setEname(rs.getString(2));
				                                            		   emp.setDesg(rs.getString(3));
				                                            		   emp.setSalary(rs.getDouble(4));
				                                            		   emp.setDeptno(rs.getInt(5));
				                                            		   list.add(emp);
				                                            	   }//end of while
				                                            	   return list;				                                            	   
		                                                       },
				                                               desg1,desg2);//end of method		arg3 or also var args
				                                     
		return empList;
	}//
	
	
	
	
	//anonymous inner class
	/*
	 * @Override public List<Employee> getEmployeesByDesg(String desg1, String
	 * desg2) { List<Employee> empsList=jt.query(GET_EMPS_BY_DESG, //ARG1 new
	 * ResultSetExtractor<List<Employee>>() {
	 * 
	 * @Override public List<Employee> extractData(ResultSet rs) throws
	 * SQLException,DataAccessException{ //copy RS object records to List<Employee>
	 * obj List<Employee> list=new ArrayList<Employee>(); while(rs.next()) {
	 * Employee emp=new Employee(); emp.setEno(rs.getInt(1));
	 * emp.setEname(rs.getString(2)); emp.setDesg(rs.getString(3));
	 * emp.setSalary(rs.getDouble(4)); emp.setDeptno(rs.getInt(5)); //copy each emp
	 * obj to list<emp> list.add(emp); } return list; }//extracData },//Anonymous
	 * class ARG2 desg1,desg2);// ARG3 return empsList; }
	 */
	
	/*
	 * //nested inner class private class EmployeeExtractor implements
	 * ResultSetExtractor<List<Employee>>{
	 * 
	 * @Override public List<Employee> extractData(ResultSet rs) throws
	 * SQLException, DataAccessException { List<Employee> list=new ArrayList();
	 * while(rs.next()) { //copy each record one Employee obj Employee emp=new
	 * Employee(); emp.setEno(rs.getInt(1)); emp.setEname(rs.getString(2));
	 * emp.setDesg(rs.getString(3)); emp.setSalary(rs.getDouble(4));
	 * emp.setDeptno(rs.getInt(5)); //add each emp obj to List<Employee>
	 * list.add(emp); } return list; }//extractData()
	 * 
	 * }//inner class
	 */	
}
