package com.company.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class AbstractDatedEntity extends AbstractEntity {

    @Column(name = "created_at")
    @NotNull
    @CreationTimestamp
    //@ApiModelProperty(required = true, value = "Assigned by framework at Create Time")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    //@ApiModelProperty(required = false, value = "Assigned by framework at Update Time")
    private Timestamp updatedAt;
}
