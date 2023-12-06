package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    Iterable<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Integer id);
    Page<Employee> getAllPagingEmployees(int offSet, int pageSize);
}
