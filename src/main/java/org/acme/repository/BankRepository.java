package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.acme.domain.Bank;

@ApplicationScoped
public class BankRepository implements PanacheRepository<Bank> {
}