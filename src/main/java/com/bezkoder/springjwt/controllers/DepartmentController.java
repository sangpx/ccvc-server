package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.entity.Department;
import com.bezkoder.springjwt.serviceImpl.DepartmentServiceIml;
import com.bezkoder.springjwt.services.DepartmentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
// localhost:8080/api/departments/getAllDepartment
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired //tu dong tao ra DI dung chung cho ca ung dung - Inject DepartmentServiceImpl
    private DepartmentSerivce departmentSerivce;

    //Get All Department
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllDepartment")
    public  Iterable<Department> getAllDepartments() {
            return departmentSerivce.getAllDepartments();
    }
    //Get Department By ID
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getDepartmentById/{id}")
    public Department getDepartmentById(@PathVariable() Integer id) {
        return departmentSerivce.getDepartmentById(id);
    }

    //Create Department
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return departmentSerivce.createDepartment(department);
    }
    //Update Department
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @PutMapping("/updateDepartment")
    public  Department updateDepartment(@RequestBody Department department) {
        return departmentSerivce.updateDepartment(department);
    }
    @PreAuthorize("hasRole('ADMIN')")
    //Delete Department
    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable() Integer id) {
        departmentSerivce.deleteDepartment(id);
    }
}
