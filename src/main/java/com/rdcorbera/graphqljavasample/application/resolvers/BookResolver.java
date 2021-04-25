package com.rdcorbera.graphqljavasample.application.resolvers;

import com.rdcorbera.graphqljavasample.infrastructure.repositories.BookRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver {
  @Autowired
  private BookRepository bookRepository;

  public DataFetcher getBookByIdDataFetcher() {
    return dataFetchingEnvironment -> {
      int bookId = Integer.parseInt(dataFetchingEnvironment.getArgument("id"));
      return bookRepository.findById(bookId).orElse(null);
    };
  }
}
