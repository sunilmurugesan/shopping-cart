package com.deltacapita.shoppingcart.data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Pricing details for each item.
 */
public class PricingLookup {

  public static Map<String, BigDecimal> PRICING_LOOKUP = Map.of(
      "Melon", BigDecimal.valueOf(0.50),
      "Lime", BigDecimal.valueOf(0.15),
      "Apple", BigDecimal.valueOf(0.35),
      "Banana", BigDecimal.valueOf(0.20)
  );

  public BigDecimal getPrice(String itemName) {
    return PRICING_LOOKUP.get(itemName);
  }

}
