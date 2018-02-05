package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tenants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantEntity extends AbstractEntity {

    @Column(name = "name")
    protected String name;
}