package org.acme.fetcher.mutation;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.acme.domain.Account;
import org.acme.domain.Bank;
import org.acme.domain.User;
import org.acme.domain.input.AccountInput;
import org.acme.repository.AccountRepository;
import org.acme.repository.BankRepository;
import org.acme.repository.UserRepository;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

@GraphQLApi
@RequiredArgsConstructor
public class AccountMutation {
  private final AccountRepository accountRepository;
  private final BankRepository bankRepository;
  private final UserRepository userRepository;
  @Mutation("createAccount")
  @Transactional
  public Account createAccount(@Name("account") AccountInput account) {
    User user = userRepository.findById(account.getUserId());
    Bank bank = bankRepository.findById(account.getBankId());
    var accountToSave = new Account(null,
        account.getName(), account.getAlias(), account.getAmount(), user, bank);
    accountRepository.persistAndFlush(accountToSave);
    return accountToSave;
  }
}