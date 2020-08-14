package com.anubhav.springbootjpa.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer"})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int empId;
	
	@Column(name = "name")
	private String empName;
	
	@Column(name = "mail")
	private String empMail;
	
	@Column(name = "gender")
	private String empGender;
	
	//Always use java.sql.Date and not java.util.Date when using
	//field of Date type to mapped with column field also of Date type
	@Column(name = "doj")
	private Date empDoj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptId",referencedColumnName = "id",nullable = false)
	@JsonIgnore
	private Department department;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empTypeId",referencedColumnName = "id",nullable = false)
	private EmployeeType employeeType;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public Date getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empDoj == null) ? 0 : empDoj.hashCode());
		result = prime * result + ((empGender == null) ? 0 : empGender.hashCode());
		result = prime * result + empId;
		result = prime * result + ((empMail == null) ? 0 : empMail.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empDoj == null) {
			if (other.empDoj != null)
				return false;
		} else if (!empDoj.equals(other.empDoj))
			return false;
		if (empGender == null) {
			if (other.empGender != null)
				return false;
		} else if (!empGender.equals(other.empGender))
			return false;
		if (empId != other.empId)
			return false;
		if (empMail == null) {
			if (other.empMail != null)
				return false;
		} else if (!empMail.equals(other.empMail))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}

}
