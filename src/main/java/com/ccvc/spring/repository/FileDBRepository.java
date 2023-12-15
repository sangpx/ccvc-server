package com.ccvc.spring.repository;

import com.ccvc.spring.models.entity.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//save(FileDB), findById(id), findAll()
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
