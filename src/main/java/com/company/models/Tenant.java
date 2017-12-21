package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    @Column(name = "Id")
    @Id
    protected Long id;

    @Column(name = "name")
    protected String name;
}