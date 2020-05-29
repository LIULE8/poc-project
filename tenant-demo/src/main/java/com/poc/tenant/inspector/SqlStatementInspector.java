package com.poc.tenant.inspector;

import com.poc.tenant.constant.SqlConstant;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class SqlStatementInspector implements StatementInspector {
  @Override
  public String inspect(String sql) {
    log.info("before: " + sql);
    if (StringUtils.hasText(sql) && sql.contains(SqlConstant.FIND_TENANT_ID_WHERE)) {
      // todo 拿 user info
      String newTenantId = "789";
      if (!StringUtils.hasText(newTenantId)) {
        throw new RuntimeException("tenantId can not be empty");
      }
      String where = String.format("%s = %s", SqlConstant.TENANT_ID, newTenantId);
      sql = sql.replaceAll(SqlConstant.FIND_TENANT_ID_WHERE, where);
      log.warn("after: " + sql);
    }
    return sql;
  }
}
