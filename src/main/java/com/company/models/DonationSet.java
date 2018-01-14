package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "donation_sets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationSet {

    @Column(name = "id")
    @Id
    protected Long id;

    @OneToMany()
    @JoinTable()
    protected List<Donation> contents;
}