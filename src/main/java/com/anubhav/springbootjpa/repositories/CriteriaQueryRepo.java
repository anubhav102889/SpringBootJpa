package com.anubhav.springbootjpa.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.anubhav.springbootjpa.entities.Department;
import com.anubhav.springbootjpa.entities.DepartmentEmployeeFields;
import com.anubhav.springbootjpa.entities.Employee;
import com.anubhav.springbootjpa.entities.EmployeeType;



@Repository
public class CriteriaQueryRepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<DepartmentEmployeeFields>  criteriaQuery(Integer deptId) {
		CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
		CriteriaQuery<DepartmentEmployeeFields> criteriaQuery=criteriaBuilder.createQuery(DepartmentEmployeeFields.class);
		Root<Department> deptRoot=criteriaQuery.from(Department.class);
		Join<Department,Employee> emplJoin=deptRoot.join("employees");
		Join<Employee,EmployeeType> empTypeJoin=emplJoin.join("employeeType");
		List<Order> orders=new ArrayList<>();
		criteriaQuery.select(criteriaBuilder.construct(DepartmentEmployeeFields.class, deptRoot.get("deptId"),
				deptRoot.get("deptName"),emplJoin.get("empId"),emplJoin.get("empName"),
				emplJoin.get("empGender"),emplJoin.get("empMail"),emplJoin.get("empDoj"),
		        empTypeJoin.get("employeeTypeId"),empTypeJoin.get("employeeTypeName")))
		.where(criteriaBuilder.equal(deptRoot.get("deptId"),deptId))
		.groupBy(deptRoot.get("deptId"),
				deptRoot.get("deptName"),emplJoin.get("empId"),emplJoin.get("empName"),
				emplJoin.get("empName"),emplJoin.get("empGender"),emplJoin.get("empMail")
				,emplJoin.get("empDoj"),empTypeJoin.get("employeeTypeId"),empTypeJoin.get("employeeTypeName"));
		
		TypedQuery<DepartmentEmployeeFields> query=entityManager.createQuery(criteriaQuery);	
		List<DepartmentEmployeeFields> resultList=query.getResultList();	
		return resultList;
			
	}
	
	public List<DepartmentEmployeeFields>  criteriaQueryUsingPageAble(Department department,Pageable pageable) {
		CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
		CriteriaQuery<DepartmentEmployeeFields> criteriaQuery=criteriaBuilder.createQuery(DepartmentEmployeeFields.class);
		Root<Employee> emplRoot=criteriaQuery.from(Employee.class);
		Join<Employee,Department> deptJoin=emplRoot.join("department");
		Join<Employee,EmployeeType> empTypeJoin=emplRoot.join("employeeType");
		
		List<Predicate> predicates=new ArrayList<>();
		if(!StringUtils.isEmpty(department.getDeptName())) {
			Predicate predicateString=criteriaBuilder.like(deptJoin.get("deptName"), "%"+department.getDeptName()+"%");
			predicates.add(predicateString);
			
		}
		if(department.getDeptId()>0) {
			Predicate predicateInteger=criteriaBuilder.equal(deptJoin.get("deptId"), department.getDeptId());
			predicates.add(predicateInteger);
		}
		
		criteriaQuery.select(criteriaBuilder.construct(DepartmentEmployeeFields.class, deptJoin.get("deptId"),
				deptJoin.get("deptName"),emplRoot.get("empId"),emplRoot.get("empName"),
				emplRoot.get("empGender"),emplRoot.get("empMail"),emplRoot.get("empDoj"),
		        empTypeJoin.get("employeeTypeId"),empTypeJoin.get("employeeTypeName")))
		.where(predicates.toArray(new Predicate[predicates.size()]))
		.groupBy(deptJoin.get("deptId"),
				deptJoin.get("deptName"),emplRoot.get("empId"),emplRoot.get("empName"),
				emplRoot.get("empName"),emplRoot.get("empGender"),emplRoot.get("empMail")
				,emplRoot.get("empDoj"),empTypeJoin.get("employeeTypeId"),empTypeJoin.get("employeeTypeName"))
		.orderBy(QueryUtils.toOrders(pageable.getSort(), emplRoot, criteriaBuilder));
		TypedQuery<DepartmentEmployeeFields> query=entityManager.createQuery(criteriaQuery);
		query.setFirstResult((int)pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		List<DepartmentEmployeeFields> resultList=query.getResultList();
		
		return resultList;
			
	}

}
