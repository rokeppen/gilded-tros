package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassItemTest {

    @Test
    void testSingleUpdate15DaysBeforeSellIn() {
        var item = new Item("Backstage passes for Re:Factor", 15, 20);
        new GildedTros(item).updateItems();
        assertEquals(14, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void testSingleUpdate10DaysBeforeSellIn() {
        var item = new Item("Backstage passes for Re:Factor", 10, 40);
        new GildedTros(item).updateItems();
        assertEquals(9, item.sellIn);
        assertEquals(42, item.quality);
    }

    @Test
    void testSingleUpdate5DaysBeforeSellIn() {
        var item = new Item("Backstage passes for HAXX", 5, 40);
        new GildedTros(item).updateItems();
        assertEquals(4, item.sellIn);
        assertEquals(43, item.quality);
    }

    @Test
    void testUpdateUntilNegativeSellIn() {
        var item = new Item("Backstage passes for HAXX", 5, 40);
        new GildedTros(item).updateItems(6);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void testQualityBoundary() {
        var item = new Item("Backstage passes for HAXX", 5, 40);
        new GildedTros(item).updateItems(5);
        assertEquals(0, item.sellIn);
        assertEquals(50, item.quality);
    }
}
