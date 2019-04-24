package com.company.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
@Data
public class AbstractDatedEntity extends AbstractEntity {

    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @Column(name = "last_updated", nullable = true)
    private Date lastUpdated;

    @PrePersist
    protected void onCreate() {
        dateCreated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = new Date();
    }
}
