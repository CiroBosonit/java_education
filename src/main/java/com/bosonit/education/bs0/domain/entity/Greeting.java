package com.bosonit.education.bs0.domain.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Greeting {

  private String content;

  public String getContent() {

    return "Hola " + this.content;
  }

}
