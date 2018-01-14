package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="donations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {

    @Column(name = "id")
    @Id
    protected Long id;

    @Column(name="amount")
    protected Double amount;

    @ManyToOne
    @JoinColumn(name="charity_id")
    protected Charity charity;

    @Column(name = "content")
    protected String content;

    @Column(name = "description")
    protected String description;
}