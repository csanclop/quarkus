package org.acme.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String alias;
  private BigDecimal amount;
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;
  @ManyToOne(fetch = FetchType.LAZY)
  private Bank bank;
}