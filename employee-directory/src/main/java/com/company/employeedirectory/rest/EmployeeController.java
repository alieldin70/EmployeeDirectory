package com.company.employeedirectory.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.employeedirectory.entity.Employee;
import com.company.employeedirectory.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private EmployeeService employeeServ;

//constructor injection	
	public EmployeeController(EmployeeService employeeService) {
		employeeServ = employeeService;
	}

// create an end point to get all employees
	@GetMapping("/employee")
	List<Employee> AllEmp() {
		List<Employee> AllEmp = employeeServ.GetAll();
		return AllEmp;
	}
	//get user by id 
	@GetMapping("/employee/{id}")
	Employee getEmpById(@PathVariable String id) {
		int parsedid=Integer.parseInt(id); 
		Employee emp= employeeServ.GetEmpById(parsedid);
		return emp;
	}
//add new employee
	@PostMapping("/employee")
	Employee addNewEmp(@RequestBody Employee EMP) {
		Employee emp= employeeServ.AddNewEmp(EMP);
		return emp;
	}
	@PutMapping("/employee")
	Employee updateEmp(@RequestBody Employee EMP) {
		Employee emp= employeeServ.updateEmp(EMP);
		return emp;
	}
	//delete employee by id
	@DeleteMapping("/employee/{id}")
	String deleteEmpById(@PathVariable String id) {
		int parsedid=Integer.parseInt(id); 
		employeeServ.deleteEmpById(parsedid);
		return "employee is deleted successfully";
	}
	//delete all employees
	@DeleteMapping("/employee")
	String deleteEmpById() {
		employeeServ.deleteAll();
		return "employees are deleted successfully";
	}
	//get all employees salaries
	@GetMapping("/employee/salary")
	List<Integer> AllEmpSalaries() {
		List<Integer> empSalaries =new ArrayList<>();
		List<Employee> AllEmp = employeeServ.GetAll();
		for (Employee emp:AllEmp) {
			empSalaries.add(emp.getEmpSalary());
		}
		return empSalaries;
	}
	//get employees by salary
	@GetMapping("/employee/salary/{salaryVal}")
	List<Employee> getEmpBySalary(@PathVariable int salaryVal){
		List<Employee> emplis=employeeServ.getEmpBySalary(salaryVal);
		return emplis;
	} 
	//get employees by hiredate
	@GetMapping("/employee/hiredate")
	List<Employee> getEmpBySalary(@RequestBody String hiredate){
		List<Employee> emplis=employeeServ.getEmpByHireDate(hiredate);
		return emplis;
	} 
	
	

}
