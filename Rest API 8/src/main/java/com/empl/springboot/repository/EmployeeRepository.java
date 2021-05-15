package com.empl.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empl.springboot.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
