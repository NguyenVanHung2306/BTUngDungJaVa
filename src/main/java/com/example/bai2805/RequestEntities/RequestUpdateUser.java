package com.example.bai2805.RequestEntities;

import com.example.bai2805.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateUser {
    private String id;
    private String username;
    private String email;
    private String firstname;
    private String lastName;
}
