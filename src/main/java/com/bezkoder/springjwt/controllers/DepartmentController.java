package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.dto.department.DepartmentCreateDto;
import com.bezkoder.springjwt.models.dto.department.DepartmentDTO;
import com.bezkoder.springjwt.models.dto.department.DepartmentUpdateDto;
import com.bezkoder.springjwt.models.entity.Department;
import com.bezkoder.springjwt.services.DepartmentSerivce;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
// localhost:8080/api/departments/getAllDepartment
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired //tu dong tao ra DI dung chung cho ca ung dung - Inject DepartmentServiceImpl
    private DepartmentSerivce departmentSerivce;

    //Get All Department
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllDepartment")
    public List<DepartmentDTO> getAllDepartments() {
            return departmentSerivce.getAllDepartments().stream()
                    .map(department -> modelMapper.map(department, DepartmentDTO.class)).collect(Collectors.toList());
    }
    //Get Department By ID
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable() Integer id) {
        Department department =  departmentSerivce.getDepartmentById(id);
        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        return ResponseEntity.ok().body(departmentDTO);
    }

    //Create Department
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentCreateDto request) {
        // convert DTO sang Entity
        Department departmentRequest = modelMapper.map(request, Department.class);
        Department department = departmentSerivce.createDepartment(departmentRequest);
        // convert entity sang DTO
        DepartmentDTO departmentResponse = modelMapper.map(department, DepartmentDTO.class);
        return new ResponseEntity<DepartmentDTO>(departmentResponse, HttpStatus.CREATED);
    }
    //Update Department
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @PutMapping("/updateDepartment")
    public  ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO request) {
        // convert DTO sang Entity
        Department departmentRequest = modelMapper.map(request, Department.class);
        Department department = departmentSerivce.updateDepartment(departmentRequest);
        // convert entity sang DTO
        DepartmentDTO departmentResponse = modelMapper.map(department, DepartmentDTO.class);
        return ResponseEntity.ok().body(departmentResponse);
    }
    @PreAuthorize("hasRole('ADMIN')")
    //Delete Department
    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable() Integer id) {
        departmentSerivce.deleteDepartment(id);
    }
}
