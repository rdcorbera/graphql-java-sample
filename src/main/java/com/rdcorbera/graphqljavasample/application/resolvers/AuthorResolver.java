package com.rdcorbera.graphqljavasample.application.resolvers;

import com.rdcorbera.graphqljavasample.infrastructure.entities.Book;
import com.rdcorbera.graphqljavasample.infrastructure.repositories.AuthorRepository;
import graphql.schema.DataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver {
  @Autowired
  private AuthorRepository authorRepository;

  Logger logger = LoggerFactory.getLogger(BookResolver.class);

  public DataFetcher getAuthorDataFetcher() {
    return dataFetchingEnvironment -> {
      logger.info("Execution ID: " + dataFetchingEnvironment.getExecutionId());
      logger.info("Execution Info Path: " + dataFetchingEnvironment.getExecutionStepInfo().getPath().toString());

      Book book = dataFetchingEnvironment.getSource();
      int authorId = book.getAuthor().getId();

      return authorRepository.findById(authorId).orElse(null);
    };
  }
}
