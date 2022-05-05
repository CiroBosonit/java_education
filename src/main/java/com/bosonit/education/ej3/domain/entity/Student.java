package com.bosonit.education.ej3.domain.entity;

import com.bosonit.education.ej3.domain.enums.BranchEnum;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_student")
  private int id;

  @OneToOne
  @JoinColumn(name = "id_person")
  private Person person;

  @Column(name = "num_hours_week", nullable = false)
  private int num_hours_week;

  @Column(name = "comments")
  private String commments;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_professor")
  private Professor professor;

  @Enumerated(EnumType.STRING)
  @Column(name = "branch", nullable = false)
  private BranchEnum branch;

  @ManyToMany(mappedBy = "students")
  private List<Course> courses = new ArrayList<>();

  public Student(int id) {

    this.id = id;
  }

}
