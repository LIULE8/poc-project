package com.poc.tenant.repository;


import com.poc.tenant.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AddressRepository
    extends JpaRepository<Address, Integer>, JpaSpecificationExecutor<Address> {
  List<Address> findByAreaLike(String area);
}
