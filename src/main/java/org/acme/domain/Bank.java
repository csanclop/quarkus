package org.acme.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Bank {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String country;
  @OneToMany(mappedBy = "bank")
  private Set<User> users;
  @OneToMany(mappedBy = "bank")
  private Set<Account> accounts;
}