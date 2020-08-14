package com.anubhav.springbootjpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employeeType")
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer"})
public class EmployeeType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int employeeTypeId;
	
	@Column(name = "name")
	private String employeeTypeName;

	public int getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(int employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public String getEmployeeTypeName() {
		return employeeTypeName;
	}

	public void setEmployeeTypeName(String employeeTypeName) {
		this.employeeTypeName = employeeTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeTypeId;
		result = prime * result + ((employeeTypeName == null) ? 0 : employeeTypeName.hashCode());
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
		EmployeeType other = (EmployeeType) obj;
		if (employeeTypeId != other.employeeTypeId)
			return false;
		if (employeeTypeName == null) {
			if (other.employeeTypeName != null)
				return false;
		} else if (!employeeTypeName.equals(other.employeeTypeName))
			return false;
		return true;
	}
	
	
}
