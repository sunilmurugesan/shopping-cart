package com.deltacapita.shoppingcart.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Discount {

  private long minItem;
  private BigDecimal discountPercentage;

}
