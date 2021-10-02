package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.acme.domain.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}