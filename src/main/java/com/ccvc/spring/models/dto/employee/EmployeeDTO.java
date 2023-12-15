package com.ccvc.spring.models.dto.employee;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer employeeid;
    @NotEmpty(message = "EmployeeCode should not be null or empty")
    private String employeeCode;
    @NotEmpty(message = "EmployeeName should not be null or empty")
    private String employeeName;
    private String email;
    private String address;
    private LocalDateTime dateOfBirth;
    private String careerTitle;
    private Byte gender;
    private Integer departmentid;
}
