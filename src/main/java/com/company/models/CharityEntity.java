package com.company.models;

import com.company.xfers.Charity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Optional;

@Entity
@Table(name = "charities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CharityEntity extends AbstractDatedEntity {

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "ein", nullable = false)
    private String ein;

    @Column(name = "description")
    protected String description;

    public Optional<CharityEntity> create(Charity charity, Session session) {
        CharityEntity charityEntity = new CharityEntity();

        return Optional.of(charityEntity);
    }
}