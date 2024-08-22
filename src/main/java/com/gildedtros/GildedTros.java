package com.gildedtros;

import com.gildedtros.item.CurrentItemFactory;
import com.gildedtros.item.DecoratedItem;
import com.gildedtros.item.ItemFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class GildedTros {

    Item[] items;
    private final List<DecoratedItem> decoratedItems = new ArrayList<>();


    public GildedTros(Item[] items) {
        this.items = items;
        for (Item item : items) {
            ItemFactory factory = CurrentItemFactory.getInstance();
            decoratedItems.add(factory.decorate(item));
        }
    }

    public GildedTros(Item item) {
        this(new Item[] { item });
    }

    public void updateItems() {
        decoratedItems.forEach(DecoratedItem::update);
    }

    public void updateItems(int times) {
        IntStream.range(0, times).forEach(i -> updateItems());
    }
}