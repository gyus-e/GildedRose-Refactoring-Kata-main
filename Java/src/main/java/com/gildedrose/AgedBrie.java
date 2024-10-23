package com.gildedrose;

public class AgedBrie extends ItemForSale {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseSellInValue();
        increaseQuality();
        if (isExpired()) {
            increaseQuality();
        }
    }
}
