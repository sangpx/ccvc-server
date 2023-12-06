package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.entity.Department;

public interface DepartmentSerivce {
    Iterable<Department> getAllDepartments();
    Department getDepartmentById(Integer id);
    Department createDepartment(Department department);
    Department updateDepartment(Department department);
    void deleteDepartment(Integer id);
}
