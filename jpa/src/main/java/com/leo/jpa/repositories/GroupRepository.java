package com.leo.jpa.repositories;

import com.leo.jpa.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<Group, Integer> {
}