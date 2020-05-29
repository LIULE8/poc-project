package com.poc.tenant.repository;

import com.poc.tenant.model.FieldAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FieldAssociationRepository
    extends JpaRepository<FieldAssociation, Integer>, JpaSpecificationExecutor<FieldAssociation> {}
