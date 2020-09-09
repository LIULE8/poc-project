package com.leo.model.tenant.repository;


import com.leo.model.tenant.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AddressRepository
        extends JpaRepository<Address, Integer>, JpaSpecificationExecutor<Address> {
    List<Address> findByAreaLike(String area);
}
