package com.deltacapita.shoppingcart.checkout;

import com.deltacapita.shoppingcart.Basket;
import com.deltacapita.shoppingcart.data.PricingLookup;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BasketCheckout implements Checkout {

  private final Basket basket;
  private final PricingLookup pricingLookup;
  private final Checkout discount;

  @Override
  public BigDecimal calculate() {
    BigDecimal totalPrice = basket.items().stream()
        .map(pricingLookup::getPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    return totalPrice.subtract(discount.calculate());
  }
}
