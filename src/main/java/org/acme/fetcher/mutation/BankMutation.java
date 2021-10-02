package org.acme.fetcher.mutation;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.acme.domain.Bank;
import org.acme.domain.input.BankInput;
import org.acme.repository.BankRepository;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

@GraphQLApi
@RequiredArgsConstructor
public class BankMutation {

  private final BankRepository repository;

  @Mutation("createBank")
  @Transactional
  public Bank createBank(@Name("bank") BankInput bank) {

    var bankToSave = new Bank(null, bank.getName(), bank.getCountry(), null, null);
    repository.persist(bankToSave);

    return bankToSave;
  }

}