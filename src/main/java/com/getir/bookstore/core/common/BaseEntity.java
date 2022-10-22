package com.getir.bookstore.core.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name = "CREATED_ON")
    private Date createdOn;

    @LastModifiedDate
    @Column(name = "LAST_CHANGED_ON")
    private Date lastChangedOn;

    @CreatedBy
    @Column(name = "CREATED_BY_USER_ID")
    private String createdByUser;

    @LastModifiedBy
    @Column(name = "LAST_CHANGED_BY_USER_ID")
    private String lastChangedByUser;

}
