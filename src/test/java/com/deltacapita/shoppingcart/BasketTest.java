package com.deltacapita.shoppingcart;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import com.deltacapita.shoppingcart.model.Item;
import org.junit.jupiter.api.Test;

class BasketTest {

  private Basket basket = new Basket();

  @Test
  void itemsCanBeAddedAndRetrievedToBasketSuccessfully() {
    Item apple = new Item("Apple");
    Item orange = new Item("Orange");
    basket.addItem(apple);
    basket.addItem(orange);

    assertThat(basket.items(), hasSize(2));
  }


}