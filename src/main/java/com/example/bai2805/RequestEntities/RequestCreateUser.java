package com.example.bai2805.RequestEntities;

import com.example.bai2805.Entities.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateUser {
    private String username;
    private String email;
    private String firstname;
    private String lastName;
    private boolean isDeleted;
    private Role role;
}
