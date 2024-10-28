package model;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
    	this.items=items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateStrategy.getUpdateStrategy(item);
        }
    }
}
