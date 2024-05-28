package com.example.bai2805.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastName;
    private boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(String id, String username, String email, String firstname, String lastName, boolean isDeleted, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastName = lastName;
        this.isDeleted = isDeleted;
        this.role = role;
    }
}
