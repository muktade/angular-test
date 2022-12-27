package com.example.demo.test.controller;


import com.example.demo.test.entity.Employee;
import com.example.demo.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/emp/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("save")
    public String save(@RequestBody Employee employee) {

        String res = "";
        Employee emp = employeeService.findEmployee(employee.getEmail());
        if (emp != null) {
            res = "Email is already added.";
        } else {
            employeeService.saveEmployee(employee);
            res = "Employee registered successfully";
        }
        return res;
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
