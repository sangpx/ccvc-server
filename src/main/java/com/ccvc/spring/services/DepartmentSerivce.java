package com.ccvc.spring.services;

import com.ccvc.spring.models.entity.Department;

import java.util.List;

public interface DepartmentSerivce {
    List<Department> getAllDepartments();
    Department getDepartmentById(Integer id);
    Department createDepartment(Department department);
    Department updateDepartment(Department department);
    void deleteDepartment(Integer id);
}
