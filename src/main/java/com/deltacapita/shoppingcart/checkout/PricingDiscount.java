package com.deltacapita.shoppingcart.checkout;

import java.math.BigDecimal;

public class PricingDiscount implements Checkout {

  @Override
  public BigDecimal calculate() {
    return BigDecimal.ZERO;
  }
}
