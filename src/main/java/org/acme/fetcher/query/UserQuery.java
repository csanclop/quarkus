package org.acme.fetcher.query;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.acme.domain.User;
import org.acme.repository.UserRepository;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
@RequiredArgsConstructor
public class UserQuery {

  private final UserRepository userRepository;


  @Query("users")
  public List<User> findAll() {

    return (List<User>) userRepository.findAll();

  }

  @Query("user")
  public User findById(@Name("id") Long id) {

    return userRepository.findById(id);

  }
}