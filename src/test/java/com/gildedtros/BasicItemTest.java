package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicItemTest {

    @Test
    void testSingleUpdate() {
        var item = new Item("Ring of Cleansening Code", 10, 20);
        new GildedTros(item).updateItems();
        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    void testUpdateUntilNegativeSellIn() {
        var item = new Item("Ring of Cleansening Code", 10, 20);
        new GildedTros(item).updateItems(11);
        assertEquals(-1, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    void testQualityBoundary() {
        var item = new Item("Ring of Cleansening Code", 10, 20);
        new GildedTros(item).updateItems(20);
        assertEquals(-10, item.sellIn);
        assertEquals(0, item.quality);
    }
}
