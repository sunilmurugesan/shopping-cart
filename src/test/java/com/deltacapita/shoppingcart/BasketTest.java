package com.deltacapita.shoppingcart;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;

class BasketTest {

  private Basket basket = new Basket();

  @Test
  void itemsCanBeAddedAndRetrievedToBasketSuccessfully() {
    basket.addItem("Apple");
    basket.addItem("Orange");

    assertThat(basket.items(), hasSize(2));
  }


}