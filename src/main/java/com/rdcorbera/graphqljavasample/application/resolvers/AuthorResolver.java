package com.rdcorbera.graphqljavasample.application.resolvers;

import com.rdcorbera.graphqljavasample.infrastructure.entities.Book;
import com.rdcorbera.graphqljavasample.infrastructure.repositories.AuthorRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver {
  @Autowired
  private AuthorRepository authorRepository;

  public DataFetcher getAuthorDataFetcher() {
    return dataFetchingEnvironment -> {
      Book book = dataFetchingEnvironment.getSource();
      int authorId = book.getAuthor().getId();

      return authorRepository.findById(authorId).orElse(null);
    };
  }
}
