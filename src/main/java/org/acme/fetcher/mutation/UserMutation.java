package org.acme.fetcher.mutation;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.acme.domain.User;
import org.acme.domain.input.UserInput;
import org.acme.repository.UserRepository;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

@GraphQLApi
@RequiredArgsConstructor
public class UserMutation {

  private final UserRepository userRepository;

  @Mutation("createUser")
  @Transactional
  public User createUser(@Name("user") UserInput user) {

    var userToSave = new User(null, user.getFirstName(), user.getLastName(), user.getAge(), user.getAddress(), user.getCountry(), user.getCity(), null, null);
    userRepository.persistAndFlush(userToSave);
    return userToSave;
  }

}