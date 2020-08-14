package com.anubhav.springbootjpa.entities;

import java.util.Date;

public class DepartmentEmployee {
	
private Integer deptId;
	
	private String deptName;
	
	private Integer empId;
	
	private String empName;
	
	private String empGender;
	
	private String empMail;
	
	private Date empDoj;
	
	private Integer empTypeId;
	
	private String empTypeName;
	
	private Character isContractor;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public Date getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}

	public Integer getEmpTypeId() {
		return empTypeId;
	}

	public void setEmpTypeId(Integer empTypeId) {
		this.empTypeId = empTypeId;
	}

	public String getEmpTypeName() {
		return empTypeName;
	}

	public void setEmpTypeName(String empTypeName) {
		this.empTypeName = empTypeName;
	}

	public Character getIsContractor() {
		return isContractor;
	}

	public void setIsContractor(Character isContractor) {
		this.isContractor = isContractor;
	}

	public DepartmentEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Here Data has to be type of java.util only it doesnt take java.sql as it 
	//gives an error at run time
	public DepartmentEmployee(Integer deptId, String deptName, Integer empId, String empName, String empGender,
			String empMail, Date empDoj, Integer empTypeId, String empTypeName, Character isContractor) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.empId = empId;
		this.empName = empName;
		this.empGender = empGender;
		this.empMail = empMail;
		this.empDoj = empDoj;
		this.empTypeId = empTypeId;
		this.empTypeName = empTypeName;
		this.isContractor = isContractor;
	}
	
	public DepartmentEmployee(Integer deptId, String deptName, Integer empId, String empName, String empGender,
			String empMail, Date empDoj, Integer empTypeId, String empTypeName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.empId = empId;
		this.empName = empName;
		this.empGender = empGender;
		this.empMail = empMail;
		this.empDoj = empDoj;
		this.empTypeId = empTypeId;
		this.empTypeName = empTypeName;
	}
	
	
	
	


}
