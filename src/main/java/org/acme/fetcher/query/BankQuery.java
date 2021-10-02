package org.acme.fetcher.query;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.acme.domain.Bank;
import org.acme.repository.BankRepository;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
@RequiredArgsConstructor
public class BankQuery {

  private final BankRepository repository;

  @Query("banks")
  public List<Bank> findAll() {
    return repository.findAll().stream().collect(Collectors.toList());
  }

  @Query("bank")
  public Bank findById(@Name("id") Long id) {

    return repository.findById(id);
  }
}