package com.rdcorbera.graphqljavasample.infrastructure.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="AUTHORS")
@Data
public class Author {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String firstName;
  private String lastName;
}
