package com.leo.model.tenant.repository;


import com.leo.model.tenant.entity.TestUUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TestUUIDRepository extends JpaRepository<TestUUID, Integer>, JpaSpecificationExecutor<TestUUID> {
}
