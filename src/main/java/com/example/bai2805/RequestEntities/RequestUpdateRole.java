package com.example.bai2805.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateRole {
    private String role_id;
    private String role_name;
    private boolean isDeleted;
}
