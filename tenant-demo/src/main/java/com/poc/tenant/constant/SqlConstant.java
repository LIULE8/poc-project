package com.poc.tenant.constant;

public interface SqlConstant {
  String TENANT_ID = "TENANT_ID";
  String TENANT_ID_CONSTANT = "'@@@@@@@@'";
  String FIND_TENANT_ID_WHERE = TENANT_ID + " = " + TENANT_ID_CONSTANT;
}
