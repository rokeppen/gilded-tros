package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgingItemTest {

    @Test
    void testSingleUpdate() {
        var item = new Item("Good Wine", 2, 0);
        new GildedTros(item).updateItems();
        assertEquals(1, item.sellIn);
        assertEquals(1, item.quality);
    }

    @Test
    void testUpdateUntilNegativeSellIn() {
        var item = new Item("Good Wine", 2, 0);
        new GildedTros(item).updateItems(3);
        assertEquals(-1, item.sellIn);
        assertEquals(4, item.quality);
    }

    @Test
    void testQualityBoundary() {
        var item = new Item("Good Wine", 2, 0);
        new GildedTros(item).updateItems(30);
        assertEquals(-28, item.sellIn);
        assertEquals(50, item.quality);
    }

}
