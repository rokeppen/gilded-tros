package com.gildedtros.item;

import com.gildedtros.Item;

/**
 * Smelly items degrade in quality twice as fast as normal items.
 */
public class SmellyItem extends DecoratedItem {

    public SmellyItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        addToQuality(-2);
    }
}
