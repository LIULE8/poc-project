package com.poc.tenant.repository;

import com.poc.tenant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository
    extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    List<User> findByNameLike(String name);


    @Modifying
    @Query("update User set name = ?1 where name = 'leo'")
    void updateName(String name);

    @Query("from User u where u.name like ?1")
    List<User> findByName(String name);
}
