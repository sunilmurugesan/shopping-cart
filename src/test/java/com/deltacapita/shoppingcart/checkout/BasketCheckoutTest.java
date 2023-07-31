package com.deltacapita.shoppingcart.checkout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasketCheckoutTest {

  private BasketCheckout basketCheckout;

  @BeforeEach
  public void setup() {
    basketCheckout = new BasketCheckout();
  }

  @Test
  @DisplayName("Total price of the items added to the basket can be calculated correctly")
  void shouldCalculateTheTotalPrice() {
    assertThat(basketCheckout.calculate(), is(BigDecimal.ZERO));
  }
}