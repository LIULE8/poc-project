package com.leo.model.tenant.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.leo.model.common.IDLog;
import com.leo.model.constant.SqlConstant;
import lombok.*;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_address")
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, exclude = "user")
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
}
