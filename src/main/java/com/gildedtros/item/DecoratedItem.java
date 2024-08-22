package com.gildedtros.item;

import com.gildedtros.Item;

/**
 * A normal item decreases in quality after each sellIn update,
 * but twice as fast when it sellIn date has passed.
 * It's quality always stays between 0 and 50.
 */
public class DecoratedItem {

    protected final Item item;

    public DecoratedItem(Item item) {
        this.item = item;
    }

    public void update() {
        updateQuality();
        updateSellIn();
        if (item.sellIn < 0) {
            handleNegativeSellIn();
        }
    }

    protected final void addToQuality(int amount) {
        item.quality = Math.min(50, Math.max(item.quality + amount, 0));
    }

    protected void updateQuality() {
        addToQuality(-1);
    }

    protected void updateSellIn() {
        item.sellIn--;
    }

    protected void handleNegativeSellIn() {
        updateQuality();
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
