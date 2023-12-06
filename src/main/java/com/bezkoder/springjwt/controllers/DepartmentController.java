package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.entity.Department;
import com.bezkoder.springjwt.serviceImpl.DepartmentServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
// localhost:8080/api/departments/getAllDepartment
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired //tu dong tao ra DI dung chung cho ca ung dung - Inject DepartmentServiceImpl
    private DepartmentServiceIml departmentServiceImpl;

    //Get All Department
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllDepartment")
    public  Iterable<Department> getAllDepartments() {
            return departmentServiceImpl.getAllDepartments();
    }
    //Get Department By ID
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getDepartmentById/{id}")
    public Department getDepartmentById(@PathVariable() Integer id) {
        return departmentServiceImpl.getDepartmentById(id);
    }

    //Create Department
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return departmentServiceImpl.createDepartment(department);
    }
    //Update Department
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateDepartment")
    public  Department updateDepartment(@RequestBody Department department) {
        return departmentServiceImpl.updateDepartment(department);
    }
    @PreAuthorize("hasRole('ADMIN')")
    //Delete Department
    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable() Integer id) {
        departmentServiceImpl.deleteDepartment(id);
    }
}
