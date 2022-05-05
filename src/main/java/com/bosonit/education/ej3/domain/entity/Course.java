package com.bosonit.education.ej3.domain.entity;

import com.bosonit.education.ej3.domain.enums.BranchEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_course")
  private int id;

  @ManyToOne
  @JoinColumn(name = "id_professor")
  private Professor professor;

  @ManyToOne
  @JoinColumn(name = "id_student")
  private Student student;

  @Column(name = "value")
  private String value;

  @Column(name = "comments")
  private String comments;

  @Column(name = "initial_date", nullable = false)
  private LocalDate initialDate;

  @Column(name = "finish_date")
  private LocalDate finishDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "branch", nullable = false)
  private BranchEnum branch;

  @ManyToMany
  @JoinColumn(name = "id_course")
  private List<Student> students = new ArrayList<>();

}
