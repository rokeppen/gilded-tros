package com.gildedtros.item;

import com.gildedtros.Item;

/**
 * Legendary items should never be sold nor ever lose quality.
 */
public class LegendaryItem extends DecoratedItem {
    public LegendaryItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {}

    @Override
    protected void updateSellIn() {}

    @Override
    protected void handleNegativeSellIn() {}
}
