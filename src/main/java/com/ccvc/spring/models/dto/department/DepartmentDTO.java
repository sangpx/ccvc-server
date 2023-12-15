package com.ccvc.spring.models.dto.department;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Integer departmentid;
    private String departmentCode;
    private String departmentName;
}
