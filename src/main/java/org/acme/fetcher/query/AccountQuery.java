package org.acme.fetcher.query;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.acme.domain.Account;
import org.acme.repository.AccountRepository;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
@RequiredArgsConstructor
public class AccountQuery {
  private final AccountRepository repository;
  @Query("accounts")
  public List<Account> findAll() {
    return repository.findAll().stream().collect(Collectors.toList());
  }
  @Query("account")
  public Account findById(@Name("id") Long id) {
    return repository.findById(id);
  }
}