package com.deltacapita.shoppingcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {

  private final List<String> items = new ArrayList<>();

  public void addItem(String item) {
    items.add(item);
  }

  public List<String> items() {
    return Collections.unmodifiableList(items);
  }

}
