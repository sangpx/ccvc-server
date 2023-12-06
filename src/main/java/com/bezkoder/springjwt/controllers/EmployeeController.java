package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.PagedResult;
import com.bezkoder.springjwt.models.entity.Employee;
import com.bezkoder.springjwt.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    //Get All Employee
    @GetMapping("/getAllEmployee")
    @PreAuthorize("hasRole('ADMIN')")
    public  Iterable<Employee> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }
    //Get Employee By ID
    @GetMapping("/getEmployeeById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee getEmployeeById(@PathVariable() Integer id) {
        return employeeServiceImpl.getEmployeeById(id);
    }

    //Create Employee
    @PostMapping("/addEmployee")
    @PreAuthorize("hasRole('ADMIN')")
    public  Employee addEmployee(@RequestBody Employee employee) {
        return employeeServiceImpl.createEmployee(employee);
    }
    //Update Employee
    @PutMapping("/updateEmployee")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeServiceImpl.updateEmployee(employee);
    }

    //Delete Employee
    @DeleteMapping("/deleteEmployee/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEmployee(@PathVariable() Integer id) {
        employeeServiceImpl.deleteEmployee(id);
    }

    //Get - Paging Employee
    @GetMapping("/pagination/{offSet}/{pageSize}")
    @PreAuthorize("hasRole('ADMIN')")
    public PagedResult<Page<Employee>> getPaging (@PathVariable int offSet, @PathVariable int pageSize) {
        Page<Employee> employeesWithPagination = employeeServiceImpl.getAllPagingEmployees(offSet, pageSize);
        return new PagedResult<>(employeesWithPagination.getSize(), employeesWithPagination);
    }
}
