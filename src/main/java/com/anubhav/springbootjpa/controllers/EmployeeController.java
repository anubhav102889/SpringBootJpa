package com.anubhav.springbootjpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anubhav.springbootjpa.entities.Department;
import com.anubhav.springbootjpa.entities.DepartmentEmployee;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeFields;
import com.anubhav.springbootjpa.entities.Employee;
import com.anubhav.springbootjpa.repositories.CriteriaQueryRepo;
import com.anubhav.springbootjpa.services.EmployeeService;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CriteriaQueryRepo criteriaQueryRepo;
	
	@GetMapping(value = "/departmentEmployeePage")
	public 
	@ResponseBody Page<DepartmentEmployee> departmentEmployeePage(Pageable pageable){
		return Optional.ofNullable(employeeService.departmentEmployeePage(pageable))
				.filter(page->{
					return page.getNumberOfElements()>0;
				})
				.map(page->{
					return page;
				})
				.orElse(null);
	}
	
	@GetMapping(value = "/departmentemployeefields")
	public 
	ResponseEntity <List<DepartmentEmployeeFields>> departmentemployeefields(Pageable pageable){
		return Optional.ofNullable(employeeService.departmentemployeefields(pageable))
				.filter(list->{
					return !CollectionUtils.isEmpty(list);
				})
				.map(list->{
					return new ResponseEntity<>(list, HttpStatus.OK);
				})
				.orElseGet(()->{
					return new ResponseEntity("no results found",HttpStatus.NOT_FOUND);
				});
	}
	
	@GetMapping(value = "/criteriaQuery/{deptId}")
	public 
	ResponseEntity <List<DepartmentEmployeeFields>> criteriaQuery(@PathVariable(value = "deptId") Integer deptId){
		return Optional.ofNullable(criteriaQueryRepo.criteriaQuery(deptId))
				.filter(list->{
					return !CollectionUtils.isEmpty(list);
				})
				.map(list->{
					return new ResponseEntity<>(list, HttpStatus.OK);
				})
				.orElseGet(()->{
					return new ResponseEntity("no results found",HttpStatus.NOT_FOUND);
				});
	}
	
	@PostMapping(value = "/criteriaQueryUsingPageAble")
	public 
	ResponseEntity <List<DepartmentEmployeeFields>> criteriaQueryUsingPageAble(
			@RequestBody Department department,Pageable pageable){
		return Optional.ofNullable(criteriaQueryRepo.criteriaQueryUsingPageAble(department, pageable))
				.filter(list->{
					return !CollectionUtils.isEmpty(list);
				})
				.map(list->{
					return new ResponseEntity<>(list, HttpStatus.OK);
				})
				.orElseGet(()->{
					return new ResponseEntity("no results found",HttpStatus.NOT_FOUND);
				});
	}
	
	
	
	
}
