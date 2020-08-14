package com.anubhav.springbootjpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anubhav.springbootjpa.entities.DepartmentEmployee;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeFields;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeInt;
import com.anubhav.springbootjpa.services.DepartmentService;

@Controller
public class DepartmentController {

	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value = "/departmentemployeefields/{deptId}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<DepartmentEmployeeFields>> departmentemployeefields(@PathVariable(value = "deptId") Integer deptId){
		return Optional.ofNullable(departmentService.departmentemployeefields(deptId))
				.filter(list->!CollectionUtils.isEmpty(list))
				.map(list->{
					return new ResponseEntity<>(list, HttpStatus.OK);
				})
				.orElseGet(()->{
					return new ResponseEntity("Bad Request",HttpStatus.BAD_REQUEST);
				});
	}
	
	@PostMapping(value = "/departmentemployeefieldsList",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<DepartmentEmployeeFields>> departmentemployeefieldsList(@RequestParam(value = "ab")String ab){
		return Optional.ofNullable(departmentService.departmentemployeefieldsList())
				.filter(list->!CollectionUtils.isEmpty(list))
				.map(list->{
					return new ResponseEntity<>(list, HttpStatus.OK);
				})
				.orElseGet(()->{
					return new ResponseEntity("Bad Request",HttpStatus.BAD_REQUEST);
				});
	}
	
	
	@GetMapping(value = "/departmentemployee/{deptId}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<DepartmentEmployee>> departmentemployee(@PathVariable(value = "deptId")Integer deptId){
		return Optional.ofNullable(departmentService.departmentemployee(deptId))
				.filter(list->!CollectionUtils.isEmpty(list))
				.map(list->{
					return new ResponseEntity<>(list, HttpStatus.OK);
				})
				.orElseGet(()->{
					return new ResponseEntity("Bad Request",HttpStatus.BAD_REQUEST);
				});
	}
	
	@GetMapping(value = "/departmentemployeeInt/{deptId}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<DepartmentEmployeeInt>> departmentemployeeInt(@PathVariable(value = "deptId")Integer deptId){
		return Optional.ofNullable(departmentService.departmentemployeeInt(deptId))
				.filter(list->!CollectionUtils.isEmpty(list))
				.map(list->{
					return new ResponseEntity<>(list, HttpStatus.OK);
				})
				.orElseGet(()->{
					return new ResponseEntity("Bad Request",HttpStatus.BAD_REQUEST);
				});
	}
	
	@GetMapping(value = "/home")
	public String home() {
		return "home";
	}
	
	
}
