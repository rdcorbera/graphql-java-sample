package com.rdcorbera.graphqljavasample.infrastructure.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="BOOKS")
@Data
public class Book {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String name;
  private int pageCount;
  private LocalDate publicationDate;

  @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Author author;
}
