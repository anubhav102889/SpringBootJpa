package com.anubhav.springbootjpa.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.anubhav.springbootjpa.entities.Department;
import com.anubhav.springbootjpa.entities.DepartmentEmployee;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeFields;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeInt;
import com.anubhav.springbootjpa.entities.Employee;
import com.anubhav.springbootjpa.entities.EmployeeType;
import com.anubhav.springbootjpa.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	public List<DepartmentEmployeeFields> departmentemployeefields( Integer deptId){
		return Optional.ofNullable(deptId)
				.filter(id->id>0)
				.map(id->{
					return departmentRepository.departmentemployeefields(id);
				})
				.orElse(null);
	}
	
	public List<DepartmentEmployeeFields> departmentemployeefieldsList(){
		List<DepartmentEmployeeFields> departmentEmployeeFields=departmentRepository.departmentemployeefieldsList();
		if(CollectionUtils.isEmpty(departmentEmployeeFields)) {
			return null;
		}
		else {
			return departmentEmployeeFields;
		}
		
	}
	
	public List<DepartmentEmployee> departmentemployee( Integer deptId){
		return Optional.ofNullable(deptId)
				.filter(id->id>0)
				.map(id->{
					return departmentRepository.departmentemployee(id);
				})
				.orElse(null);
	}
	
	public List<DepartmentEmployeeInt> departmentemployeeInt( Integer deptId){
		return Optional.ofNullable(deptId)
				.filter(id->id>0)
				.map(id->{
					return departmentRepository.departmentemployeeInt(id);
				})
				.orElse(null);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Department update(DepartmentEmployeeFields departmentEmployeeFields) {
	 return Optional.ofNullable(departmentEmployeeFields)
			 .filter(obj->obj.getDeptId()>0)
			 .map(obj->{
				 Department department=new Department();
				 department.setDeptName(obj.getDeptName());
				 Department departmentSaved=departmentRepository.save(department);
				 if(departmentSaved.getDeptId()>0 && !StringUtils.isEmpty(departmentSaved.getDeptName())){
					 Employee employee=new Employee();
					 employee.setEmpName(obj.getEmpName());
					 employee.setEmpGender(obj.getEmpGender());
					 employee.setEmpDoj((Date) obj.getEmpDoj());
					 employee.setEmpMail(obj.getEmpMail());
					 EmployeeType employeeType=new EmployeeType();
					 employeeType.setEmployeeTypeId(Integer.parseInt(obj.getEmpTypeName()));
					 employee.setEmployeeType(employeeType);
					 Integer rowsSaved=employeeService.updateEmployee(employee);
					 if(rowsSaved > 0) {
						 return department;
					 }
					 else {
						 return null;
					 }
				 }
				 else {
					 return null;
				 }
			 }).orElse(null);
	}
}
