package com.company.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/3/17
 */

@Entity
@Table(name = "donors")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class DonorEntity extends AbstractDatedEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DonationEntity> donations = new ArrayList<DonationEntity>();

    public DonorEntity(String name, int age) {
        this.setId(null);
        this.name = name;
        this.age = age;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("DonorEntity[name=" + name);
        sb.append(", age=" + age);
        sb.append("]");

        return sb.toString();
    }
}
