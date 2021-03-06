package com.leo.model.tenant.entity;

import com.leo.model.common.IDLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "t_user")
@AllArgsConstructor
@NoArgsConstructor
//@Where(clause = SqlConstant.FIND_TENANT_ID_WHERE)
public class User extends IDLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    private String associateId;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
//  @BatchSize(size = 2)
    private Set<Address> addresses;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "company_uuid",
            referencedColumnName = "id",
            nullable = false,
            columnDefinition = "varchar(20)")
    private Company company;

//  @Embedded
//  @Where(clause = SqlConstant.FIND_TENANT_ID_WHERE)
//  private EIDLog eidLog = new EIDLog();

//  @Override
//  public String toString() {
//    return "User{"
//        + "id="
//        + id
//        + ", name='"
//        + name
//        + '\''
//        + ", age="
//        + age
//        + ", tenantID="
//        + getTenantID()
//        + ", associateId="
//        + getAssociateId()
//        + ", createBy="
//        + getCreateBy()
//        + ", updateBy="
//        + getUpdateBy()
//        + '}';
//  }
}

