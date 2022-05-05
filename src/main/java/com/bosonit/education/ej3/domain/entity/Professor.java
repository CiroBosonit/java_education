package com.bosonit.education.ej3.domain.entity;

import com.bosonit.education.ej3.domain.enums.BranchEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "professor")
public class Professor {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_professor")
  private int id;

  @OneToOne
  @JoinColumn(name = "id_person")
  private Person person;

  @OneToMany
  @JoinColumn(name = "id_professor")
  private List<Student> students = new ArrayList<>();

  @Column(name = "comments")
  private String comments;

  @Enumerated(EnumType.STRING)
  @Column(name = "branch", nullable = false)
  private BranchEnum branch;

}
