package com.rdcorbera.graphqljavasample.application.resolvers;

import com.rdcorbera.graphqljavasample.infrastructure.repositories.BookRepository;
import graphql.schema.DataFetcher;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookResolver {
  @Autowired
  private BookRepository bookRepository;

  Logger logger = LoggerFactory.getLogger(BookResolver.class);

  public DataFetcher getBooksDataFetcher() {
    return dataFetchingEnvironment -> {
      logger.info("Execution ID: " + dataFetchingEnvironment.getExecutionId());
      logger.info("Execution Info Path: " + dataFetchingEnvironment.getExecutionStepInfo().getPath().toString());

      String publishedAfter = dataFetchingEnvironment.getArgument("publicationAfter");

      if (!StringUtils.isAllEmpty(publishedAfter)) {
        return bookRepository.findByPublicationDateGreaterThan(LocalDate.parse(publishedAfter));
      }

      return bookRepository.findAll();
    };
  }

  public DataFetcher getBookByIdDataFetcher() {
    return dataFetchingEnvironment -> {
      logger.info("Execution ID: " + dataFetchingEnvironment.getExecutionId());
      logger.info("Execution Info Path: " + dataFetchingEnvironment.getExecutionStepInfo().getPath().toString());

      int bookId = Integer.parseInt(dataFetchingEnvironment.getArgument("id"));
      return bookRepository.findById(bookId).orElse(null);
    };
  }
}
