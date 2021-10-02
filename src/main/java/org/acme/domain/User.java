package org.acme.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private int age;
  private String address;
  private String country;
  private String city;
  @OneToMany(mappedBy = "user")
  private Set<Account> accounts;
  @ManyToOne()
  private Bank bank;
}