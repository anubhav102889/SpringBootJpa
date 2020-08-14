package com.anubhav.springbootjpa.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.anubhav.springbootjpa.entities.Department;
import com.anubhav.springbootjpa.entities.DepartmentEmployee;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeFields;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeInt;

@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
	
	@Query(nativeQuery = true)
	public List<DepartmentEmployeeFields> departmentemployeefields(@Param(value = "deptId") Integer deptId);
	
	@Query(nativeQuery = true)
	public List<DepartmentEmployeeFields> departmentemployeefieldsList();
	
	@Query(nativeQuery = true)
	public List<DepartmentEmployee> departmentemployee(@Param(value = "deptId") Integer deptId);
		
	public List<DepartmentEmployeeInt> departmentemployeeInt(@Param(value = "Id") Integer deptId);
	

}
