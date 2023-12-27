package com.ccvc.spring.serviceImpl;

import com.ccvc.spring.models.entity.ERole;
import com.ccvc.spring.models.entity.Role;
import com.ccvc.spring.repository.RoleRepository;
import com.ccvc.spring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service //Đánh dấu một Class là tầng Service, phục vụ các logic nghiệp vụ.

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findByRoleName(ERole roleName) {
        return roleRepository.findByName(roleName);
    }
}
