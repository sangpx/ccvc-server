package com.ccvc.spring.serviceImpl;

import com.ccvc.spring.models.entity.Department;
import com.ccvc.spring.repository.DepartmentRepository;
import com.ccvc.spring.services.DepartmentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Đánh dấu một Class là tầng Service, phục vụ các logic nghiệp vụ.

public class DepartmentServiceIml implements DepartmentSerivce {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return  departmentRepository.findAll();
    }

    //if there are not any department with that id than this service return object with null values
    @Override
    public Department getDepartmentById(Integer id) {
        return  departmentRepository.findById(id).orElse(new Department());
    }

    @Override
    public Department createDepartment(Department department) {
        return  departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        //Tim Kiem Department da ton tai
        Department existingDepartment = departmentRepository.findById(department.getDepartmentID())
                .orElse(null);
        //Thuc hien Update
        existingDepartment.setDepartmentCode(department.getDepartmentCode());
        existingDepartment.setDepartmentName(department.getDepartmentName());
        existingDepartment.setCreatedBy(department.getCreatedBy());
        existingDepartment.setCreatedDate(department.getCreatedDate());
        existingDepartment.setModifiedBy(department.getModifiedBy());
        existingDepartment.setModifiedDate(department.getModifiedDate());
        return  departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}
