package com.example.bai2805.Services;

import com.example.bai2805.Entities.Role;
import com.example.bai2805.Entities.User;
import com.example.bai2805.Repositories.RoleRepository;
import com.example.bai2805.RequestEntities.RequestCreateRole;
import com.example.bai2805.RequestEntities.RequestUpdateRole;
import com.example.bai2805.RequestEntities.RequestUpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role createRole(RequestCreateRole requestCreateRole) {
        try {
            Role role = new Role();
            role.setRole_id(requestCreateRole.getRole_id());
            role.setRole_name(requestCreateRole.getRole_name());
            return roleRepository.save(role);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(String id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found")
        );
    }

    public Role updateRole(String id, RequestUpdateRole requestUpdateRole) {
        try {
            Role role = getRoleById(id);
            role.setRole_name(requestUpdateRole.getRole_name());
            return roleRepository.save(role);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteRoleById(String id) {
        Role role = getRoleById(id);
        role.setDeleted(true);
        roleRepository.save(role);
    }
}
