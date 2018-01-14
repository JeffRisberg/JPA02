package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="charities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Charity {

    @Column(name = "id")
    @Id
    protected Long id;

    @Column(name = "content")
    protected String content;

    @Column(name = "description")
    protected String description;
}