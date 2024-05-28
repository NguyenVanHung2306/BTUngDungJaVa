package com.example.bai2805.Repositories;

import com.example.bai2805.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
