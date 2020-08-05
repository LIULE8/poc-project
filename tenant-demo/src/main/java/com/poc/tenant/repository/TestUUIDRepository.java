package com.poc.tenant.repository;

import com.poc.tenant.model.TestUUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TestUUIDRepository extends JpaRepository<TestUUID, Integer>, JpaSpecificationExecutor<TestUUID> {
}
