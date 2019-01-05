package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends AbstractDatedEntity {

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    protected OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    protected DonorEntity donor;

    @OneToMany()
    @JoinColumn(name = "donation_id")
    protected List<DonationEntity> contents;
}