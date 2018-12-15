package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "donations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DonationEntity extends AbstractDatedEntity {

    @Column(name = "amount")
    protected Double amount;

    @ManyToOne
    @JoinColumn(name = "charity_id")
    protected CharityEntity charity;

    @Column(name = "content")
    protected String content;

    @Column(name = "description")
    protected String description;
}