package com.deltacapita.shoppingcart.checkout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import com.deltacapita.shoppingcart.Basket;
import com.deltacapita.shoppingcart.data.PricingLookup;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BasketCheckoutTest {

  @Mock
  private Basket basket;
  @Mock
  private Checkout pricingDiscount;

  private Checkout checkout;

  @BeforeEach
  public void setup() {
    checkout = new BasketCheckout(basket, new PricingLookup(), pricingDiscount);
  }

  @Test
  @DisplayName("Total price of the items added to the basket can be calculated correctly")
  void shouldCalculateTheTotalPrice() {
    when(basket.items()).thenReturn(List.of("Apple", "Apple", "Banana", "Lime", "Melon"));
    when(pricingDiscount.calculate()).thenReturn(BigDecimal.ZERO);
    assertThat(checkout.calculate(), is(BigDecimal.valueOf(1.55)));
  }

  @Test
  @DisplayName("Total price of the items added to the basket can be calculated correctly after applying the discount")
  void shouldCalculateTheTotalPriceWithDiscount() {
    when(basket.items()).thenReturn(List.of("Apple", "Apple", "Banana", "Lime", "Melon", "Melon"));
    when(pricingDiscount.calculate()).thenReturn(BigDecimal.valueOf(0.50));
    assertThat(checkout.calculate(), is(BigDecimal.valueOf(1.55)));
  }

  @Test
  @DisplayName("Empty basket should calculate to zero total price")
  void shouldCalculateToZeroForEmptyBasket() {
    when(basket.items()).thenReturn(Collections.emptyList());
    when(pricingDiscount.calculate()).thenReturn(BigDecimal.valueOf(0.00));
    assertThat(checkout.calculate(), is(BigDecimal.valueOf(0.00)));
  }
}