package com.gildedtros.item;

import com.gildedtros.Item;

/**
 * Backstage passes increase in quality as its sellIn value approaches,
 * quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
 * but quality drops to 0 after the sellIn date.
 */
public class BackstagePassItem extends DecoratedItem {
    public BackstagePassItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (item.sellIn < 6) {
            addToQuality(3);
        } else if (item.sellIn < 11) {
            addToQuality(2);
        } else {
            addToQuality(1);
        }
    }

    @Override
    protected void handleNegativeSellIn() {
        item.quality = 0;
    }
}
