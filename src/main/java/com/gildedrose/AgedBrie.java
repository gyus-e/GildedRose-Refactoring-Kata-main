package com.gildedrose;

class AgedBrie extends ItemForSale {

    AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    AgedBrie(String name, int sellIn, int quality, String id) {
        super(name, sellIn, quality, id);
    }

    @Override
    void updateQuality() {
        decreaseSellInValue();
        increaseQuality();
        if (isExpired()) {
            increaseQuality();
        }
    }
}
