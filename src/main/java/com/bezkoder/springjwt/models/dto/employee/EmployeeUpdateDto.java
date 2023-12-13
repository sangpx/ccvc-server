package com.bezkoder.springjwt.models.dto.employee;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public class EmployeeUpdateDto {
    private Integer employeeid;
    @NotEmpty(message = "EmployeeCode should not be null or empty")
    private String employeeCode;
    @NotEmpty(message = "EmployeeName should not be null or empty")
    private String employeeName;
    private String email;
    private String address;
    private LocalDateTime dateOfBirth;
    private String phoneNumber;
    private String careerTitle;
    private Byte gender;
    private String accountBank;
    private String nameBank;
    private String branchBank;
    private Integer departmentid;
    private LocalDateTime identityIssureDate;
    private String identityIssurePlace;
    private String identityNumber;
    private String landlineNumber;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
}
