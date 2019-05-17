package com.company.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "donations")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class DonationEntity extends AbstractDatedEntity {

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donor_id", insertable = false, updatable = false)
    @JsonIgnore
    private DonorEntity donor;

    @Column(name = "donor_id")
    private Long donorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charity_id", insertable = false, updatable = false)
    @JsonIgnore
    private CharityEntity charity;

    @Column(name = "charity_id")
    private Long charityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrderEntity order;

    public DonationEntity(Double amount) {
        this.setId(null);
        this.amount = amount;
    }

    public DonationEntity(Double amount, DonorEntity donor, long donorId, CharityEntity charity, long charityId) {
        this.setId(null);
        this.amount = amount;
        this.donor = donor;
        this.donorId = donorId;
        this.charity = charity;
        this.charityId = charityId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Donation[date=" + getDateCreated());
        sb.append(", amount=" + amount);
        sb.append("]");

        return sb.toString();
    }
}
