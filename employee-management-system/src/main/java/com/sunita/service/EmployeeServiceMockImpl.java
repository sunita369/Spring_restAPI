package com.sunita.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sunita.domain.Employee;

@Component
public class EmployeeServiceMockImpl implements EmployeeService {

	private List<Employee> testEmployees = new ArrayList<Employee>();

	// populate the Employee List
	public EmployeeServiceMockImpl() {
		testEmployees.add(new Employee("1", "RAM", "HR","a4", 10000));
		testEmployees.add(new Employee("2", "Shyam", "Marketing", "a6", 20000));
		testEmployees.add(new Employee("3", "Ravi", "Development","a5", 30000));
		testEmployees.add(new Employee("4", "Neha", "Sales","a5" ,40000));
		testEmployees.add(new Employee("5", "Harry", "Cloud", "a7",50000));
		testEmployees.add(new Employee("6", "Hena", "Manager","a6", 60000));
	}

	// Return the Mocked Employee List
	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(testEmployees);
	}
}
