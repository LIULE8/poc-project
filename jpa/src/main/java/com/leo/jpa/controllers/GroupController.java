package com.leo.jpa.controllers;

import com.leo.jpa.entities.Group;
import com.leo.jpa.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupController {

    @Autowired
    private GroupRepository repository;

    @GetMapping
    public ResponseEntity<List<Group>> findAllGroup() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity saveGroup(@RequestBody Group group) {
        group.getUsers().forEach(users -> users.getGroups().add(group));
        repository.save(group);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateGroup(@RequestBody Group group) {
        repository.save(group);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteGroup(@PathVariable("id") Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}