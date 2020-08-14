package com.anubhav.springbootjpa.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.anubhav.springbootjpa.entities.DepartmentEmployee;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeFields;
import com.anubhav.springbootjpa.entities.Employee;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	//Pagebale works only with @Query annotation with both JPQL and native
	//But doesnt with either named query or named native query.To enable Pagination When using native query 
	//such that return type is Page<T> then use countQuery attribute of query annotation.
	//when return type is not Page<T> then no need to use countQuery attribute
	@Query("select new com.anubhav.springbootjpa.entities.DepartmentEmployee(dept.deptId,dept.deptName,"
			+" emp.empId ,emp.empName,emp.empGender,emp.empMail,emp.empDoj,empType.employeeTypeId,empType.employeeTypeName)" 
			+" from Employee emp,Department dept,EmployeeType empType" 
			+" where dept.deptId=emp.department.deptId and emp.employeeType.employeeTypeId=empType.employeeTypeId" 
			+" group by dept.deptId ,dept.deptName ," 
			+" emp.empId,emp.empName,emp.empMail," 
			+" emp.empGender,emp.empDoj,empType.employeeTypeId,empType.employeeTypeName")  
	public Page<DepartmentEmployee> departmentEmployeePage(Pageable pageable);
	
	
	
	@Query("select new com.anubhav.springbootjpa.entities.DepartmentEmployeeFields(dept.deptId,dept.deptName,"
			+" emp.empId ,emp.empName,emp.empGender,emp.empMail,emp.empDoj,empType.employeeTypeId,empType.employeeTypeName)" 
			+" from Employee emp, Department dept,EmployeeType empType" 
			+" where dept.deptId=emp.department.deptId and emp.employeeType.employeeTypeId=empType.employeeTypeId" 
			+" group by dept.deptId ,dept.deptName ," 
			+" emp.empId,emp.empName,emp.empMail," 
			+" emp.empGender,emp.empDoj,empType.employeeTypeId,empType.employeeTypeName")  
	public List<DepartmentEmployeeFields> departmentemployeefields(Pageable pageable);
	
	
	
	@Modifying
	@Query("update Employee e set e.empName=:#{#empl.empName}, e.empGender=:#{#empl.empGender},"
			+ " e.empMail=:#{#empl.empGender}, e.empDoj=:#{#empl.empDoj},"
			+ " e.employeeType.employeeTypeId=:#{#empl.employeeType.employeeTypeId} "
			+ "where e.empId=:#{#empl.empId}")
	public Integer updateEmployee (@Param(value = "empl") Employee employee);
	

}
