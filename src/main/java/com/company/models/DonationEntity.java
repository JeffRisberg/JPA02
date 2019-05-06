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
    @JoinColumn(name = "donor_id")
    @JsonIgnore
    private DonorEntity donor;

    @Column(name = "donor_id")
    private Long donorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charity_id")
    @JsonIgnore
    private CharityEntity charity;

    @Column(name = "charity_id")
    private Long charityId;

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
