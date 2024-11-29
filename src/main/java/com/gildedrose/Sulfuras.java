package com.gildedrose;

class Sulfuras extends ItemForSale {

    Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, 80);
    }

    Sulfuras(String name, int sellIn, int quality, String id) {
        super(name, sellIn, 80, id);
    }

    @Override
    void updateQuality() {
        // Does nothing: Sulfuras quality is always 80
    }

    @Override
    protected void increaseQuality() {
        // Does nothing: Sulfuras quality is always 80
    }

    @Override
    protected void decreaseQuality() {
        // Does nothing: Sulfuras quality is always 80
    }

    @Override
    protected void decreaseSellInValue() {
        // Does nothing: Sulfuras must never be sold
    }
}
