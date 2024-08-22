package com.gildedtros;

import java.util.stream.IntStream;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public GildedTros(Item item) {
        this(new Item[] { item });
    }

    public void updateItems(int times) {
        IntStream.range(0, times).forEach(i -> updateItems());
    }

    public void updateItems() {
        for (Item item : items) {
            updateQuality(item);
            updateSellIn(item);
            if (item.sellIn < 0) {
                handleNegativeSellIn(item);
            }
        }
    }

    private void updateQuality(Item item) {
        if (item.name.equals("Good Wine") || item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
                if (item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        } else {
            if (item.quality > 0) {
                if (!item.name.equals("B-DAWG Keychain")) {
                    item.quality = item.quality - 1;
                }
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals("B-DAWG Keychain")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void handleNegativeSellIn(Item item) {
        if (item.name.equals("Good Wine")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        } else {
            if (item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX")) {
                item.quality = 0;
            } else {
                if (item.quality > 0) {
                    if (!item.name.equals("B-DAWG Keychain")) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }
}