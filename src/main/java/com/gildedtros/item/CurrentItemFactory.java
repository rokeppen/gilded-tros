package com.gildedtros.item;

import com.gildedtros.Item;

import java.util.Arrays;
import java.util.List;

public class CurrentItemFactory implements ItemFactory {

    public List<String> smellyItems = Arrays.asList(
            "Duplicate Code",
            "Long Methods",
            "Ugly Variable Names"
    );

    private CurrentItemFactory() {}

    @Override
    public DecoratedItem decorate(Item item) {
        if ("Good Wine".equals(item.name)) {
            return new AgingItem(item);
        }
        if ("B-DAWG Keychain".equals(item.name)) {
            return new LegendaryItem(item);
        }
        if (item.name.startsWith("Backstage passes")) {
            return new BackstagePassItem(item);
        }
        if (smellyItems.contains(item.name)) {
            return new SmellyItem(item);
        }
        return new DecoratedItem(item);
    }

    public static CurrentItemFactory getInstance() {
        return FactoryInstanceHelper.INSTANCE;
    }

    private static class FactoryInstanceHelper {
        private static final CurrentItemFactory INSTANCE = new CurrentItemFactory();
    }
}
