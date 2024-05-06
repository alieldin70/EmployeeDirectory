package com.company.employeedirectory.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//creating our employee entity class
@Entity
@Table(name="empolyee")
public class Employee {
//create our entity fields
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="emp_name")
private String empName;
@Column(name="email")
private String email;
@Column(name="emp_role")
private String empRole;
@Column(name="emp_salary")
private int empSalary;
@Column(name="hire_date")
private String hireDate;

// generate constructors
public Employee() {
}
public Employee(String empName, String email, String empRole,int empSalary, String hireDate) {
	this.empName = empName;
	this.email = email;
	this.empRole = empRole;
	this.empSalary=empSalary;
	this.hireDate=hireDate;
}

//generate setters and getters

public int getId() {
	return id;
}
public String getHireDate() {
	return hireDate;
}
public void setHireDate(String hireDate) {
	this.hireDate = hireDate;
}
public void setId(int id) {
	this.id = id;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getEmpRole() {
	return empRole;
}
public void setEmpRole(String empRole) {
	this.empRole = empRole;
}
public int getEmpSalary() {
	return empSalary;
}
public void setEmpSalary(int empSalary) {
	this.empSalary = empSalary;
}
//generate to string Method 
@Override
public String toString() {
	return "Employee [id=" + id + ", empName=" + empName + ", email=" + email + ", empRole=" + empRole + "]";
}

}
