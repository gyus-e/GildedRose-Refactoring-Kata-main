package model;

public class Sulfuras extends ItemForSale {
    
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, 80);
    }

    @Override
    public void updateQuality() {
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
