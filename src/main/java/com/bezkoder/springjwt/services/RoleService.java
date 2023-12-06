package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.entity.ERole;
import com.bezkoder.springjwt.models.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(ERole roleName);
}
