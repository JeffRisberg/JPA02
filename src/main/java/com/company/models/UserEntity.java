package com.company.models;

import com.company.xfers.Charity;
import com.company.xfers.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AbstractEntity {

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;


    public Optional<UserEntity> create(User user, Session session) {
        return Optional.of(user);
    }
}