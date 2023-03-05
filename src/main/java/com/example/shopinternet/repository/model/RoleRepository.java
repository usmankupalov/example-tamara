package com.example.shopinternet.repository.model;

import com.example.shopinternet.model.ERole;
import com.example.shopinternet.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(ERole roleName);
}
