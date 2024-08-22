package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LegendaryItemTest {

    @Test
    void testSingleUpdate() {
        var item = new Item("B-DAWG Keychain", 0, 80);
        new GildedTros(item).updateItems();
        assertEquals(0, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void testUpdateUntilNegativeSellIn() {
        var item = new Item("B-DAWG Keychain", -1, 80);
        new GildedTros(item).updateItems();
        assertEquals(-1, item.sellIn);
        assertEquals(80, item.quality);
    }

}
