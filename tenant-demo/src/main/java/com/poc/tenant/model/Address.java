package com.poc.tenant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.poc.tenant.constant.SqlConstant;
import com.poc.tenant.model.common.IDLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Where(clause = SqlConstant.FIND_TENANT_ID_WHERE)
public class Address extends IDLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String city;

  private String area;

  //  @ManyToOne(optional = false)
  @ManyToOne
  @JoinColumn(
      name = "user_uuid",
      referencedColumnName = "id",
      nullable = false,
      columnDefinition = "char(32)")
  //  @NotFound(action= NotFoundAction.IGNORE)
  @JsonBackReference
  @WhereJoinTable(clause = SqlConstant.FIND_TENANT_ID_WHERE)
  private User user;

  @Override
  public String toString() {
    return "Address{"
        + "id="
        + id
        + ", city='"
        + city
        + '\''
        + ", tenantId='"
        + getTenantID()
        + '\''
        + ", area='"
        + area
        + '\''
        + '}';
  }
}
