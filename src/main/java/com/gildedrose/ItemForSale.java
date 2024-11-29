package com.gildedrose;

import java.util.UUID;

public class ItemForSale extends Item {

    private String id;

    public ItemForSale(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        id = UUID.randomUUID().toString();
    }

    public ItemForSale(String name, int sellIn, int quality, String id) {
        super(name, sellIn, quality);
        this.id = id;
    }

    public String getID() {
        return id;
    }

    void updateQuality() {
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
