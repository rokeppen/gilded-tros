package com.gildedtros.item;

import com.gildedtros.Item;

public interface ItemFactory {
    DecoratedItem decorate(Item item);
}
