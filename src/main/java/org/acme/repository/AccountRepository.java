package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.acme.domain.Account;

@ApplicationScoped
public class AccountRepository implements PanacheRepository<Account> {
}