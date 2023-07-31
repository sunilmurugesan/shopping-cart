package com.deltacapita.shoppingcart.checkout;

import java.math.BigDecimal;

public class BasketCheckout implements Checkout{

  @Override
  public BigDecimal calculate() {
    return BigDecimal.ZERO;
  }
}
