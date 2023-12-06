package com.bezkoder.springjwt.serviceImpl;

import com.bezkoder.springjwt.models.entity.Employee;
import com.bezkoder.springjwt.repository.EmployeeRepository;
import com.bezkoder.springjwt.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service //Đánh dấu một Class là tầng Service, phục vụ các logic nghiệp vụ.

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> getAllEmployees() {
        return  employeeRepository.findAll();
    }

    //if there are not any department with that id than this service return object with null values
    @Override
    public Employee getEmployeeById(Integer id) {
        return  employeeRepository.findById(id).orElse(new Employee());
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return  employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        //Tim Kiem Department da ton tai
        Employee existingEmployee = employeeRepository.findById(employee.getEmployeeID()).orElse(null);
        //Thuc hien Update Employee
        existingEmployee.setEmployeeCode(employee.getEmployeeCode());
        existingEmployee.setEmployeeName(employee.getEmployeeName());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAccountBank(employee.getAccountBank());
        existingEmployee.setBranchBank(employee.getBranchBank());
        existingEmployee.setNameBank(employee.getNameBank());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setCareerTitle(employee.getCareerTitle());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setIdentityIssureDate(employee.getIdentityIssureDate());
        existingEmployee.setIdentityNumber(employee.getIdentityNumber());
        existingEmployee.setLandlineNumber(employee.getLandlineNumber());
        existingEmployee.setIdentityNumber(employee.getIdentityNumber());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setCreatedBy(employee.getCreatedBy());
        existingEmployee.setCreatedDate(employee.getCreatedDate());
        existingEmployee.setModifiedBy(employee.getModifiedBy());
        existingEmployee.setModifiedDate(employee.getModifiedDate());
        return  employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> getAllPagingEmployees(int offSet, int pageSize) {
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(offSet, pageSize));
        return  employees;
    }
}
