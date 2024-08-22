package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmellyItemTest {

    @Test
    void testSingleUpdate() {
        var item = new Item("Duplicate Code", 3, 6);
        new GildedTros(item).updateItems();
        assertEquals(2, item.sellIn);
        assertEquals(4, item.quality);
    }

    @Test
    void testUpdateUntilNegativeSellIn() {
        var item = new Item("Duplicate Code", 3, 12);
        new GildedTros(item).updateItems(4);
        assertEquals(-1, item.sellIn);
        assertEquals(2, item.quality);
    }

    @Test
    void testQualityBoundary() {
        var item = new Item("Duplicate Code", 3, 6);
        new GildedTros(item).updateItems(4);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
}
