package com.bosonit.education.ej3.domain.entity;

import javax.persistence.*;

@Entity(name = "person")
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "person_id", nullable = false)
  private Integer personId;

}
