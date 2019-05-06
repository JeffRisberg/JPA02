package com.company.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends AbstractDatedEntity {

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "donor_id", insertable = false, updatable = false)
    @JsonIgnore
    private DonorEntity donor;

    @Column(name = "donor_id")
    private Long donorId;

    @OneToMany()
    @JoinColumn(name = "donation_id")
    private List<DonationEntity> contents;
}