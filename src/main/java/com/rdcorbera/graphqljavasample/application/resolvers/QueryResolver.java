package com.rdcorbera.graphqljavasample.application.resolvers;

import com.rdcorbera.graphqljavasample.infrastructure.entities.Book;
import com.rdcorbera.graphqljavasample.infrastructure.repositories.BookRepository;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

  @Autowired
  private BookRepository bookRepository;

  public List<Book> getBooks(String publishedAfter) {
    if (!StringUtils.isAllEmpty(publishedAfter)) {
      return bookRepository.findByPublicationDateGreaterThan(LocalDate.parse(publishedAfter));
    }

    return bookRepository.findAll();
  }

  public DataFetcherResult<Book> getBookById(int id) {
    Book book = bookRepository.findById(id).orElse(null);

    return DataFetcherResult.<Book>newResult()
        .data(book)
        .build();
  }
}
