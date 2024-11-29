package com.gildedrose;

import java.util.UUID;

public class ItemFactory {

    public static ItemForSale getItemForSale(Item item) {
        return getItemForSale(item.name, item.sellIn, item.quality);
    }

    public static ItemForSale getItemForSale(String name, int sellIn, int quality) {
        String id = UUID.randomUUID().toString();
        return getItemForSale(name, sellIn, quality, id);
    }

    public static ItemForSale getItemForSale(String name, int sellIn, int quality, String id) {
        quality = checkQuality(quality);

        if (name.equals("Aged Brie")) {
            return new AgedBrie(name, sellIn, quality, id);
        }
        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePass(name, sellIn, quality, id);
        }
        if (name.equals("Sulfuras, Hand of Ragnaros")) {
            return new Sulfuras(name, sellIn, 80, id);
        }
        if (name.equals("Conjured Mana Cake")) {
            return new ConjuredItem(name, sellIn, quality, id);
        }
        return new ItemForSale(name, sellIn, quality, id);
    }

    private static int checkQuality(int quality) {
        if (quality > 50) {
            return 50;
        } else {
            return quality;
        }
    }
}
