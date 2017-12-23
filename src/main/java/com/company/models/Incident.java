package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="incident")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incident {

    @Column(name = "id")
    @Id
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    protected Tenant tenant;

    @Column(name = "content")
    protected String content;

    @Column(name = "description")
    protected String description;

    @Column(name = "severity")
    protected String severity;
}