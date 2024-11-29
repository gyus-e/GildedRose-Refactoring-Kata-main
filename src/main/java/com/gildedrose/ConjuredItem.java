package com.gildedrose;

class ConjuredItem extends ItemForSale {

    ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    ConjuredItem(String name, int sellIn, int quality, String id) {
        super(name, sellIn, quality, id);
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
