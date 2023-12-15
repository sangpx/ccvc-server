package com.ccvc.spring.models.dto.department;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;


public class DepartmentUpdateDto {
    private Integer departmentid;
    @NotEmpty(message = "DepartmentCode should not be null or empty")

    private String departmentCode;
    private String departmentName;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
}
