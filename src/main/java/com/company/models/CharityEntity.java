package com.company.models;

import com.company.xfers.Charity;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class CharityEntity extends AbstractEntity {

    @Column(name = "id")
    @Id
    protected Long id;

    @Column(name = "content")
    protected String content;

    @Column(name = "description")
    protected String description;

    public Optional<CharityEntity> create(Charity charity, Session session) {
        return Optional.of(charity);
    }
}