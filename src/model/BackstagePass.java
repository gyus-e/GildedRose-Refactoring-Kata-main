package model;

public class BackstagePass extends ItemForSale {
    
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    
    @Override
    public void updateQuality() {
        decreaseSellInValue();
        if (isExpired()) {
            quality=0;
        }
        else {
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
