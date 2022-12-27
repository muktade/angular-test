package com.example.demo.test.service;


import com.example.demo.test.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee findEmployee(String email);

    String  checkAuth(Employee employee);
}
