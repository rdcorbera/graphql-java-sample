package com.rdcorbera.graphqljavasample.infrastructure.repositories;

import com.rdcorbera.graphqljavasample.infrastructure.entities.Author;
import com.rdcorbera.graphqljavasample.infrastructure.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
