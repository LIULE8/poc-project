package com.leo.jpa.repositories;

import com.leo.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}