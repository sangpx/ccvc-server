package com.ccvc.spring.repository;

import java.util.List;
import java.util.Optional;

import com.ccvc.spring.models.entity.ERole;
import com.ccvc.spring.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByName(ERole name);
}
