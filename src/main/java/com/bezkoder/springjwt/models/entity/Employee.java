package com.bezkoder.springjwt.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Đánh dấu đây là một Entity, chịu sự quản lý của Hibernate
@Table(name = "employee")
public class Employee {
    @Id // Đánh dấu thuộc tính "id" là khóa chính của bảng
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Tự động tạo giá trị khi insert
    @Column(name = "EmployeeID")
    private Integer EmployeeID;
    @NotEmpty(message = "Code may not be empty")
    @Column(name = "EmployeeCode", nullable = false, unique = true) // Ánh xạ thuộc tính "EmployeeCode" vào cột "EmployeeCode" trong bảng
    private String EmployeeCode;
    @NotEmpty(message = "Name may not be empty")
    @Column(name = "EmployeeName" , nullable = false)
    private String EmployeeName;
    @Column(name = "DateOfBirth",  nullable = true)
    private LocalDateTime DateOfBirth;
    @Column(name = "Gender" , nullable = true)
    private Byte Gender;
    @Column(name = "IdentityNumber" , nullable = true)
    private String IdentityNumber;
    @Column(name = "IdentityIssureDate" , nullable = true)
    private LocalDateTime IdentityIssureDate;
    @Column(name = "IdentityIssurePlace" , nullable = true)
    private String IdentityIssurePlace;
    @Column(name = "Email")
    private String Email;
    @Column(name = "PhoneNumber" , nullable = true)
    private String PhoneNumber;
    @Column(name = "LandlineNumber" , nullable = true)
    private String LandlineNumber;
    @Column(name = "CareerTitle" , nullable = true)
    private String CareerTitle;
    @Column(name = "Address", nullable = true)
    private String Address;
    @Column(name = "AccountBank" , nullable = true)
    private String AccountBank;
    @Column(name = "NameBank" , nullable = true)
    private String NameBank;
    @Column(name = "BranchBank", nullable = true)
    private String BranchBank;
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
    @Column(name = "DepartmentID", nullable=false)
    private Integer DepartmentID;
    // Many to One: Có nhiều employee ở 1 Phong Ban.
    @ManyToOne(optional=false)
    @JoinColumn(name = "DepartmentID", insertable=false, updatable=false) // thông qua khóa ngoại DepartmentID
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Department department;
}
