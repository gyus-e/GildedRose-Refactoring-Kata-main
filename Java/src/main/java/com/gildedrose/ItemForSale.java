package com.gildedrose;

public class ItemForSale extends Item {
    
    public ItemForSale(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    
    public void updateQuality() {
        decreaseSellInValue();
        decreaseQuality();
        if (isExpired()) {
            decreaseQuality();
        }
    }

    protected void increaseQuality() {
        if (quality < 50) {
            quality++;
        }
    }

    protected void decreaseQuality() {
        if (quality > 0) {
            quality--;
        }
    }

    protected void decreaseSellInValue() {
        sellIn--;
    }

    protected boolean isExpired() {
        return sellIn < 0;
    }
}
