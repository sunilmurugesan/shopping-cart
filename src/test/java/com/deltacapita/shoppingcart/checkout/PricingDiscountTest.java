package com.deltacapita.shoppingcart.checkout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import com.deltacapita.shoppingcart.Basket;
import com.deltacapita.shoppingcart.data.DiscountLookup;
import com.deltacapita.shoppingcart.data.PricingLookup;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PricingDiscountTest {

  @Mock
  private Basket basket;
  private Checkout checkout;

  @BeforeEach
  public void setup() {
    checkout = new PricingDiscount(basket, new PricingLookup(), new DiscountLookup());
  }

  @Test
  @DisplayName("Discount can be calculated correctly for buy one get one free")
  void shouldCalculateTheDiscountForBuy1Get1Free() {
    when(basket.items()).thenReturn(List.of("Melon", "Melon", "Apple", "Lime", "Melon"));
    assertThat(checkout.calculate(), is(BigDecimal.valueOf(0.50).setScale(2)));
  }

  @Test
  @DisplayName("Discount can be calculated correctly for three for the price of two")
  void shouldCalculateTheDiscountFor3ForThePriceOf2() {
    when(basket.items()).thenReturn(List.of("Lime", "Lime", "Lime", "Lime", "Melon"));
    assertThat(checkout.calculate(), is(BigDecimal.valueOf(0.15)));
  }

}