package com.leo.model.inspector;

import com.leo.model.constant.SqlConstant;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class SqlStatementInspector implements StatementInspector {
    @Override
    public String inspect(String sql) {
        if (StringUtils.hasText(sql) && sql.contains(SqlConstant.FIND_TENANT_ID_WHERE)) {
            // todo 拿 user info
            String newTenantId = "789";
            if (!StringUtils.hasText(newTenantId)) {
                throw new RuntimeException("tenantId can not be empty");
            }
            String where = String.format("%s = %s", SqlConstant.TENANT_ID, newTenantId);
            sql = sql.replaceAll(SqlConstant.FIND_TENANT_ID_WHERE, where);
        }
        return sql;
    }
}
