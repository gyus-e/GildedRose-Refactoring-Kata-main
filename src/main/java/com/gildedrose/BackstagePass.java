package com.gildedrose;

class BackstagePass extends ItemForSale {

    BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    BackstagePass(String name, int sellIn, int quality, String id) {
        super(name, sellIn, quality, id);
    }

    @Override
    void updateQuality() {
        decreaseSellInValue();
        if (isExpired()) {
            quality = 0;
        } else {
            increaseQuality();
            if (sellIn < 10) {
                increaseQuality();
            }
            if (sellIn < 5) {
                increaseQuality();
            }
        }
    }
}
