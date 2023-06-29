package com.first.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.first.demo.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
