package com.deltacapita.shoppingcart.checkout;

import com.deltacapita.shoppingcart.Basket;
import com.deltacapita.shoppingcart.data.DiscountLookup;
import com.deltacapita.shoppingcart.data.PricingLookup;
import com.deltacapita.shoppingcart.model.Discount;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PricingDiscount implements Checkout {

  private final Basket basket;
  private final PricingLookup pricingLookup;
  private final DiscountLookup discountLookup;

  @Override
  public BigDecimal calculate() {
    return basket.items().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .map(entry -> calculateItemDiscount(entry.getKey(), entry.getValue()))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private BigDecimal calculateItemDiscount(String itemName, long quantity) {
    BigDecimal pricePerItem = pricingLookup.getPrice(itemName);
    Discount discount = discountLookup.getDiscount(itemName);
    long noOfMultiBuy = quantity / discount.getMinItem();
    BigDecimal discountValue = pricePerItem.multiply(BigDecimal.valueOf(discount.getMinItem()))
        .multiply(discount.getDiscountPercentage())
        .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);
    return discountValue.multiply(BigDecimal.valueOf(noOfMultiBuy)).setScale(2,  RoundingMode.HALF_EVEN);
  }

}
