package com.gildedtros.item;

import com.gildedtros.Item;

public class SmellyItem extends DecoratedItem {

    public SmellyItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        addToQuality(-2);
    }
}
