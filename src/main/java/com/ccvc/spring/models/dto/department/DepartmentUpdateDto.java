package com.ccvc.spring.models.dto.department;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUpdateDto {
    private Integer departmentid;
    @NotEmpty(message = "DepartmentCode should not be null or empty")

    private String departmentCode;
    private String departmentName;
}
