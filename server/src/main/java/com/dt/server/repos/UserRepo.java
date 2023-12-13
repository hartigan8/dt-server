package com.dt.server.repos;

import com.dt.server.entities.User;
import jakarta.persistence.Id;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE role_id = ?1 LIMIT ?3 OFFSET ?2", nativeQuery = true)
    List<User> findAllByRoleName(Long roleId, Integer offset, Integer limit);
    
    Optional<User> findByEmail(String email);
}
