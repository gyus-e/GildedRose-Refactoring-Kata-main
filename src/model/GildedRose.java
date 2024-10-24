package model;

import java.util.ArrayList;

public class GildedRose {
    ArrayList<ItemForSale> itemsForSale = new ArrayList<ItemForSale>();

    public GildedRose(Item[] items) {
        for (Item i : items) {
            itemsForSale.add(ItemFactory.getItemForSale(i.name, i.sellIn, i.quality));
        }
    }

    public void updateQuality() {
        for (ItemForSale i : itemsForSale) {
            i.updateQuality();
        }
    }
}