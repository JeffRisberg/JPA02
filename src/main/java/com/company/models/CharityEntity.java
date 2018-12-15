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
public class CharityEntity extends AbstractEntity {

    @Column(name = "id")
    @Id
    protected Long id;

    @Column(name = "name")
    protected String name;

    @Column(name = "description")
    protected String description;

    @Column(name = "url")
    protected String url;

    public Optional<CharityEntity> create(Charity charity, Session session) {
        CharityEntity charityEntity = new CharityEntity();

        return Optional.of(charityEntity);
    }
}