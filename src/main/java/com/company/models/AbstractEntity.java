package com.company.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
public class AbstractEntity implements Serializable {
  @Id
  @Column(name = "id", unique = true)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
}
