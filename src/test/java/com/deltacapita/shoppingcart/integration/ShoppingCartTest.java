package com.deltacapita.shoppingcart.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.deltacapita.shoppingcart.Basket;
import com.deltacapita.shoppingcart.checkout.BasketCheckout;
import com.deltacapita.shoppingcart.checkout.Checkout;
import com.deltacapita.shoppingcart.checkout.PricingDiscount;
import com.deltacapita.shoppingcart.data.DiscountLookup;
import com.deltacapita.shoppingcart.data.PricingLookup;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

  private Basket basket;
  private PricingLookup pricingLookup;
  private DiscountLookup discountLookup;
  private Checkout pricingDiscount;
  private Checkout checkout;

  @BeforeEach
  public void setup() {
    basket = new Basket();
    pricingLookup = new PricingLookup();
    discountLookup = new DiscountLookup();
  }

  @Test
  @DisplayName("Total price of the items added to the basket can be calculated correctly after applying the discount")
  void shouldCalculateTheTotalPriceWithDiscount() {
    basket.addItem("Apple");
    basket.addItem("Banana");
    basket.addItem("Melon");
    basket.addItem("Melon");
    basket.addItem("Melon");
    basket.addItem("Lime");
    basket.addItem("Lime");
    basket.addItem("Lime");
    basket.addItem("Lime");

    // Total price = 0.35 + 0.20 + 0.50 + 0.50 + 0.50 + 0.15 + 0.15 + 0.15 + 0.15 = 2.65
    // Discount = 0.50 + 0.15 = 0.65
    // Price after discount = 2.00

    Checkout discountCheckout = new PricingDiscount(basket, pricingLookup, discountLookup);
    Checkout checkout = new BasketCheckout(basket, pricingLookup, discountCheckout);
    assertThat(checkout.calculate(), is(BigDecimal.valueOf(2.00).setScale(2)));
  }

  @Test
  @DisplayName("Total price of the items added to the basket can be calculated correctly when discounts are not applicable")
  void shouldCalculateTheTotalPriceWhenNoDiscountIsAvailable() {
    basket.addItem("Apple");
    basket.addItem("Banana");
    basket.addItem("Melon");
    basket.addItem("Lime");
    basket.addItem("Lime");

    // Total price = 0.35 + 0.20 + 0.50 + 0.15 + 0.15 = 1.35
    // Discount = 0.00
    // Price after discount = 1.35

    Checkout discountCheckout = new PricingDiscount(basket, pricingLookup, discountLookup);
    Checkout checkout = new BasketCheckout(basket, pricingLookup, discountCheckout);
    assertThat(checkout.calculate(), is(BigDecimal.valueOf(1.35)));
  }

}
