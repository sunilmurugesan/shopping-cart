package com.deltacapita.shoppingcart.checkout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PricingDiscountTest {

  private Checkout checkout;

  @BeforeEach
  public void setup() {
    checkout = new PricingDiscount();
  }

  @Test
  @DisplayName("Total price of the items added to the basket can be calculated correctly after applying discount")
  void shouldCalculateTheTotalPriceAfterApplyingDiscount() {
    assertThat(checkout.calculate(), is(BigDecimal.valueOf(0.00)));
  }
}