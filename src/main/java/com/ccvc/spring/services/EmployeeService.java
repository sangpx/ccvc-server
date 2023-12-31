package com.ccvc.spring.services;

import com.ccvc.spring.models.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Integer id);
    Page<Employee> getAllPagingEmployees(int offSet, int pageSize);
}
