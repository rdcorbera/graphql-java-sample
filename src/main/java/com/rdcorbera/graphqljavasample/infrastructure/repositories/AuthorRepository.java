package com.rdcorbera.graphqljavasample.infrastructure.repositories;

import com.rdcorbera.graphqljavasample.infrastructure.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
