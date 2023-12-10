package com.bezkoder.springjwt.serviceImpl;

import com.bezkoder.springjwt.models.entity.ERole;
import com.bezkoder.springjwt.models.entity.Role;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service //Đánh dấu một Class là tầng Service, phục vụ các logic nghiệp vụ.

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByRoleName(ERole roleName) {
        return roleRepository.findByName(roleName);
    }
}
