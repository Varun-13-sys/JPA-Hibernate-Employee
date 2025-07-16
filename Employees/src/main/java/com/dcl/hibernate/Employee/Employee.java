package com.dcl.hibernate.Employee;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Employee {
	@Id
	private int empId;
	private String eName;
	private double sal;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "EmployeesDao [empId=" + empId + ", eName=" + eName + ", sal=" + sal + "]";
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
}
