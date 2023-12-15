package com.ccvc.spring.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Tự động tạo giá trị khi insert
    private Integer DepartmentID;
    @Column (name = "DepartmentCode", unique = true)
    private String DepartmentCode;
    @Column (name = "DepartmentName")
    private String DepartmentName;
    @CreationTimestamp
    @Column(name = "CreatedDate")
    private LocalDateTime CreatedDate;
    @Column(name = "CreatedBy")
    private String CreatedBy;
    @UpdateTimestamp
    @Column(name = "ModifiedDate")
    private LocalDateTime ModifiedDate;
    @Column(name = "ModifiedBy")
    private String ModifiedBy;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL) // Quan hệ 1-n
    @JsonManagedReference
    // mappedBy trỏ tới tên biến department ở trong Employee.
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Ko sử dụng trong toString()
    private Collection<Employee> employees;
}
