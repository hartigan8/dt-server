package com.dt.server.repos;

import com.dt.server.entities.Role;
import com.dt.server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    public Role findByRole(String Role);
}
