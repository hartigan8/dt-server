package com.dt.server.services;

import com.dt.server.entities.Role;
import com.dt.server.repos.RoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role findRole(String role){
        return roleRepo.findByRole(role);
    }
}
