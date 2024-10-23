package com.gildedrose;

public class ConjuredItem extends ItemForSale {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void decreaseQuality() {
        if (quality > 0) {
            quality--;
        }
        if (quality > 0) {
            quality--;
        }
    }
}
