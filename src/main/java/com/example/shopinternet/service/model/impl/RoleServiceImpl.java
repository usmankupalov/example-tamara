package com.example.shopinternet.service.model.impl;

import com.example.shopinternet.model.ERole;
import com.example.shopinternet.model.Role;
import com.example.shopinternet.repository.model.RoleRepository;
import com.example.shopinternet.service.model.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {
        role.setRoleName(role.getRoleName());
        roleRepository.save(role);
    }

    @Override
    public Role findRoleByRoleName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
