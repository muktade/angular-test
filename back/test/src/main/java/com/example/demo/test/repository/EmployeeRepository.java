package com.example.demo.test.repository;

import com.example.demo.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByEmail(String email);
}
