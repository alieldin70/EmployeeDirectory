package com.company.employeedirectory.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company.employeedirectory.entity.Employee;
//using spring data features
public interface EmployeeRepostory extends JpaRepository<Employee,Integer> {

}
