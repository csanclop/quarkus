package org.acme.domain.input;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountInput {
  private String name;
  private String alias;
  private BigDecimal amount;
  private Long userId;
  private Long bankId;
}