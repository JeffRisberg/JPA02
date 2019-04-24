package com.company.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "donations")
@NoArgsConstructor
@Data
public class DonationEntity extends AbstractDatedEntity {

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donor_id")
    private DonorEntity donor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charity_id")
    private CharityEntity charity;

    public DonationEntity(Double amount) {
        this.setId(null);
        this.amount = amount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Donation[date=" + getDateCreated());
        sb.append(", amount=" + amount);
        sb.append("]");

        return sb.toString();
    }
}
