package com.dt.server.services;

import com.dt.server.entities.Role;
import com.dt.server.entities.User;
import com.dt.server.repos.UserRepo;
import com.dt.server.security.UserDetailsImp;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;
    private RoleService roleService;
    public UserService(UserRepo userRepo, RoleService roleService) {
        this.userRepo = userRepo;
        this.roleService = roleService;
    }


    public List<User> getPatients(Integer page) {
        if(page < 1){
            throw new IllegalArgumentException("Page number cannot be negative");
        }
        Integer offset = (page - 1) * 10;
        Integer limit = 10;
        Long roleId = roleService.findRole("patient").getId();
        return userRepo.findAllByRoleName(roleId, offset, limit);
    }

    public User save(User user){
        return userRepo.save(user);
    }

    public User getOneUserById(Long id) throws Exception {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else throw new Exception("User not found");
    }


    public User getOneUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow();
    }

    public User loadUserSCH(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            User user = getOneUserById(((UserDetailsImp) auth.getPrincipal()).getId());
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
