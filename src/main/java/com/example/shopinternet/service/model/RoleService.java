package com.example.shopinternet.service.model;

import com.example.shopinternet.model.ERole;
import com.example.shopinternet.model.Role;

public interface RoleService {
    void addRole(Role role);
    Role findRoleByRoleName(ERole roleName);
}
