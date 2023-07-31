package com.deltacapita.shoppingcart.data;

import com.deltacapita.shoppingcart.model.Discount;
import com.deltacapita.shoppingcart.model.NoDiscount;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Discount details for items
 * Buy 1, Get 1 free is equivalent to 50% discount
 * Buy 3 for the price of 2 is equivalent to 33.33% discount
 */
public class DiscountLookup {

  private static Map<String, Discount> DISCOUNT_LOOKUP =  Map.of(
      "Melon", new Discount(2, BigDecimal.valueOf(50.00)),
      "Lime", new Discount(3, BigDecimal.valueOf(33.33)),
      "Apple", new NoDiscount(),
      "Banana", new NoDiscount()
  );

  public Discount getDiscount(String itemName) {
    return DISCOUNT_LOOKUP.get(itemName);
  }

}
