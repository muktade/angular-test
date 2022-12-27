package com.example.demo.test.controller;


import com.example.demo.test.entity.Employee;
import com.example.demo.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/emp/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("save")
    public Map<String,String> save(@RequestBody Employee employee) {

        String res = "";
        Employee emp = employeeService.findEmployee(employee.getEmail());
        Map<String,String> result = new HashMap<String,String>();
        if (emp != null) {
            result.put("message", "Email is already added.");

            res = "Email is already added.";
        } else {

            result.put("message", "Unauthorized...");
            employeeService.saveEmployee(employee);
        }
        return result;
    }

    @PostMapping("login")
    public String loginEmployee(@RequestBody Employee employee) {
        return employeeService.checkAuth(employee);
    }

    @PostMapping("find-employee")
    public Employee getEmployeeDetails(@RequestBody Employee  employee){
        return employeeService.findEmployee(employee.getEmail());
    }
}
