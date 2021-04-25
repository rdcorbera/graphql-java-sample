package com.rdcorbera.graphqljavasample.infrastructure.repositories;

import com.rdcorbera.graphqljavasample.infrastructure.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

  List<Book> findByPublicationDateGreaterThan(LocalDate date);
}
