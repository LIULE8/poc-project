package com.poc.tenant.model.common;

import com.poc.tenant.constant.SqlConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Getter
@Setter
@Slf4j
@MappedSuperclass
public class IDLog extends ChangeLog {

  @Column(name = SqlConstant.TENANT_ID, updatable = false)
  protected String tenantID;

  @PrePersist
  public void initTenantID() {
    if (tenantID == null) {
      tenantID = "123";
    }
  }

  @PreUpdate
  public void updateTenantID() {
    tenantID = "789";
//    throw new RuntimeException("ccccccccccccc");
  }
}
