package model;

class AgedBrie extends ItemForSale {

    AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override void updateQuality() {
        decreaseSellInValue();
        increaseQuality();
        if (isExpired()) {
            increaseQuality();
        }
    }
}
