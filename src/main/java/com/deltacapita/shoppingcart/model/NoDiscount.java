package com.deltacapita.shoppingcart.model;

import java.math.BigDecimal;

public class NoDiscount extends Discount {

  public NoDiscount() {
    super(1, BigDecimal.ZERO);
  }

}
