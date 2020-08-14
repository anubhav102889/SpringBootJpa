package com.anubhav.springbootjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anubhav.springbootjpa.entities.DepartmentEmployee;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeFields;
import com.anubhav.springbootjpa.entities.Employee;
import com.anubhav.springbootjpa.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Page<DepartmentEmployee> departmentEmployeePage(Pageable pageable){
		return Optional.ofNullable(pageable)
				.filter(pageAble->{
					return pageAble.getPageSize()>0 && 
							!Optional.ofNullable(pageAble.getSort()).get().toString().equalsIgnoreCase("unsorted");
				})
				.map(pageAble->{
					return employeeRepository.departmentEmployeePage(pageAble);
				})
				.orElse(null);
	}
	
	public List<DepartmentEmployeeFields> departmentemployeefields(Pageable pageable){
		return Optional.ofNullable(pageable)
				.filter(pageAble->{
					return pageAble.getPageSize()>0 && 
							!Optional.ofNullable(pageAble.getSort()).get().toString().equalsIgnoreCase("unsorted");
				})
				.map(pageAble->{
					return employeeRepository.departmentemployeefields(pageAble);
				})
				.orElse(null);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer updateEmployee(Employee employee) {
		return Optional.ofNullable(employee)
				.filter(empl -> empl.getEmpId() > 0)
				.map(empl -> {
			return employeeRepository.updateEmployee(empl);
		}).orElse(null);
	}
	
	
}
