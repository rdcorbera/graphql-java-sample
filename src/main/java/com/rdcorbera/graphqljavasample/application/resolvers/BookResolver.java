package com.rdcorbera.graphqljavasample.application.resolvers;

import com.rdcorbera.graphqljavasample.infrastructure.entities.Author;
import com.rdcorbera.graphqljavasample.infrastructure.entities.Book;
import com.rdcorbera.graphqljavasample.infrastructure.repositories.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

  @Autowired
  private AuthorRepository authorRepository;

  public Author getAuthor(Book book) {
    return this.authorRepository.findById(book.getAuthorId()).orElse(null);
  }
}
