package com.company.employeedirectory.service;

import java.util.List;

import com.company.employeedirectory.entity.Employee;

public interface EmployeeService {
// GET all Employees 
List<Employee> GetAll();
//GET employee by Id 
Employee GetEmpById(int id);
Employee AddNewEmp(Employee emp);
Employee updateEmp(Employee emp);
void deleteEmpById(int id);
void deleteAll();
List<Employee> getEmpBySalary(int salary);
List<Employee> getEmpByHireDate(String hiredate);

}
