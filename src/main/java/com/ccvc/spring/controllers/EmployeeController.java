package com.ccvc.spring.controllers;

import com.ccvc.spring.models.PagedResult;
import com.ccvc.spring.models.dto.employee.EmployeeCreateDto;
import com.ccvc.spring.models.dto.employee.EmployeeDTO;
import com.ccvc.spring.models.dto.employee.EmployeeUpdateDto;
import com.ccvc.spring.models.entity.Employee;
import com.ccvc.spring.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeService employeeService;

    //Get All Employee
    @GetMapping("/getAllEmployee")
    @PreAuthorize("hasRole('ADMIN')")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
    }
    //Get Employee By ID
    @GetMapping("/getEmployeeById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable() Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        return ResponseEntity.ok().body(employeeDTO);

    }

    //Create Employee
    @PostMapping("/addEmployee")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeCreateDto request) {
        // convert DTO sang Entity
        Employee employeeRequest = modelMapper.map(request, Employee.class);
        Employee employee =  employeeService.createEmployee(employeeRequest);
        // convert entity sang DTO
        EmployeeDTO employeeResponse = modelMapper.map(employee, EmployeeDTO.class);
        return new ResponseEntity<EmployeeDTO>(employeeResponse, HttpStatus.CREATED);
    }
    //Update Employee
    @PutMapping("/updateEmployee")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeUpdateDto request) {
        // convert DTO sang Entity
        Employee employeeRequest = modelMapper.map(request, Employee.class);
        Employee employee =  employeeService.updateEmployee(employeeRequest);
        // convert entity sang DTO
        EmployeeDTO employeeResponse = modelMapper.map(employee, EmployeeDTO.class);
        return ResponseEntity.ok().body(employeeResponse);
    }

    //Delete Employee
    @DeleteMapping("/deleteEmployee/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEmployee(@PathVariable() Integer id) {
        employeeService.deleteEmployee(id);
    }

    //Get - Paging Employee
    @GetMapping("/pagination/{offSet}/{pageSize}")
    @PreAuthorize("hasRole('ADMIN')")
    public PagedResult<Page<Employee>> getPaging (@PathVariable int offSet, @PathVariable int pageSize) {
        Page<Employee> employeesWithPagination = employeeService.getAllPagingEmployees(offSet, pageSize);
        return new PagedResult<>(employeesWithPagination.getSize(), employeesWithPagination);
    }
}
