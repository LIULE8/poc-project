package com.leo.model.tenant.repository;


import com.leo.model.tenant.entity.FieldAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FieldAssociationRepository
    extends JpaRepository<FieldAssociation, Integer>, JpaSpecificationExecutor<FieldAssociation> {}
