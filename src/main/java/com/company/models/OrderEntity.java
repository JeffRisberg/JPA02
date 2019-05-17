package com.company.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<DonationEntity> contents = new ArrayList<DonationEntity>();

    public OrderEntity(OrderStatus orderStatus, DonorEntity donor, long donorId) {
        this.orderStatus = orderStatus;
        this.donor = donor;
        this.donorId = donorId;
    }

    public void addDonation(DonationEntity donationEntity) {
        contents.add(donationEntity);
        donationEntity.setOrder(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Order[date=" + getDateCreated());
        sb.append(", orderStatus=" + orderStatus);
        sb.append(", donorId=" + donorId);
        sb.append(", donationCount=" + contents.size());
        sb.append("]");

        return sb.toString();
    }
}
