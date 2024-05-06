package com.company.employeedirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.employeedirectory.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import com.company.employeedirectory.IdException;
import com.company.employeedirectory.DAO.EmployeeRepostory;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepostory employeeRepostory;
	private EntityManager entityManager;

	// constructor injection
	@Autowired
	public EmployeeServiceImpl(EmployeeRepostory employeeRepostory,EntityManager entityManager) {
		this.employeeRepostory = employeeRepostory;
		this.entityManager=entityManager;
	}

	// return all employee methods
	@Override
	public List<Employee> GetAll() {
		List<Employee> emplis = employeeRepostory.findAll();
		return emplis;
	}

//return employee by id
	@Override
	public Employee GetEmpById(int id) {
		Optional<Employee> emp = employeeRepostory.findById(id);
		if (!emp.isPresent()) {
			throw new IdException("employee not found");

		}
		Employee returnedEmp = emp.get();
		return returnedEmp;
	}

//add new employee
	@Override
	public Employee AddNewEmp(Employee emp) {
		Employee savedEmp = employeeRepostory.save(emp);
		return savedEmp;
	}
//update an existing employee 

	@Override
	public Employee updateEmp(Employee emp) {
		//verfing that employee is exist
	     GetEmpById(emp.getId());
		Employee updatedEmp = employeeRepostory.save(emp);
		return updatedEmp;
	}
//delete existing employee
	@Override
	public void deleteEmpById(int id) {
		Employee verfiyemp= GetEmpById(id);
		 employeeRepostory.delete(verfiyemp);
		
	}
//deleting all employees
	@Override
	public void deleteAll() {
		 employeeRepostory.deleteAll();
	}
//get employees by salary
	@Override
	public List<Employee> getEmpBySalary(int salary) {
		TypedQuery<Employee> getQuery= entityManager.createQuery("from Employee where empSalary=:data",Employee.class);
		getQuery.setParameter("data", salary);
		List<Employee> emplis=getQuery.getResultList();
		return emplis;
	}
	//get employees by hireDate
	@Override
	public List<Employee> getEmpByHireDate(String hiredate) {
		TypedQuery<Employee> getQuery= entityManager.createQuery("from Employee where hireDate=:data",Employee.class);
		//we split our string cause it sends all the json object not only the value
		String s1=	hiredate.split(":")[1];
		s1=s1.substring(1,s1.length()-2);
		getQuery.setParameter("data", s1);
		List<Employee> emplis=getQuery.getResultList();
		return emplis;
	}
	
}
