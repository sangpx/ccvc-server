package com.ccvc.spring.services;

import com.ccvc.spring.models.entity.ERole;
import com.ccvc.spring.models.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRoles();
    Optional<Role> findByRoleName(ERole roleName);
}
