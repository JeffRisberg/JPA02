package com.company.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class AbstractEntity {

    @Column(name = "id")
    @Id
    protected Long id;

}
