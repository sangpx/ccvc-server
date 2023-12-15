package com.ccvc.spring.models.dto.employee;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateDto {
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
    private String createdBy;
    private LocalDateTime createdDate;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
}
