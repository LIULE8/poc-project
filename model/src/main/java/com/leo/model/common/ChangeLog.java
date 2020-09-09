package com.leo.model.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public class ChangeLog implements Serializable {

    @Column(name = "CREATE_TIME", updatable = false)
    @CreatedDate
    private Instant createTime;
    @Column(name = "CREATE_BY", updatable = false)
    private String createBy;
    @Column(name = "UPDATE_TIME")
    @LastModifiedDate
    private Instant updateTime;
    @Column(name = "UPDATE_BY")
    private String updateBy;

    @PrePersist
    public void prePersist() {
        createBy = "leo";
        updateBy = "leo";
    }

    @PreUpdate
    public void preUpdate() {
        createBy = "leo1123";
        updateBy = "leo1123";
    }
}
