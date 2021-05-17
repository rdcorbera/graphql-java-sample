package com.rdcorbera.graphqljavasample.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="AUTHORS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String firstName;
  private String lastName;
}
