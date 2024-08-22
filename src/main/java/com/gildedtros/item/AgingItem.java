package com.gildedtros.item;

import com.gildedtros.Item;

/**
 * Aging items increase in quality the older they get.
 */
public class AgingItem extends DecoratedItem {
    public AgingItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        addToQuality(1);
    }
}
