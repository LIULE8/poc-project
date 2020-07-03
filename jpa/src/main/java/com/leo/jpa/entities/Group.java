package com.leo.jpa.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "t_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;
    private String name;
    @CreatedDate
    private ZonedDateTime createDate = ZonedDateTime.now();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = User.class, fetch = FetchType.LAZY, mappedBy = "groups")
    private List<User> users = new ArrayList<>();
}