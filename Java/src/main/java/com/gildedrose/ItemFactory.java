package com.gildedrose;

public class ItemFactory {
    
    public static ItemForSale getItemForSale (String name, int sellIn, int quality) {
        if (name.equals("Aged Brie")) {
            return new AgedBrie(name, sellIn, quality);
        }
        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePass(name, sellIn, quality);
        }
        if (name.equals("Sulfuras, Hand of Ragnaros")) {
            return new Sulfuras(name, sellIn, quality);
        }
        return new ItemForSale(name, sellIn, quality);
    }
}
