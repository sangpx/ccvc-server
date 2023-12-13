package com.bezkoder.springjwt.models.dto.department;

import com.bezkoder.springjwt.models.dto.employee.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Collection;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Integer departmentid;
    private String departmentCode;
    private String departmentName;
}
