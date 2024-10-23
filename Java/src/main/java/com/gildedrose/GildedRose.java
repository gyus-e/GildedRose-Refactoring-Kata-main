package com.gildedrose;

class GildedRose {
    ItemForSale[] items;

    public GildedRose(Item[] items) {
        this.items = (ItemForSale[]) items;
    }

    public void updateQuality() {
        for (ItemForSale i : items) {
            i.updateQuality();
        }
    }
}