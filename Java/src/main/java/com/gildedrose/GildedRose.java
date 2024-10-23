package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(i);
        }
    }

    private void updateItemQuality(int i) {
        if (isAgedBrie(i) || isBackstagePass(i)) {
            increaseQuality(i);
        } else {
            decreaseQuality(i);
        }

        decreaseSellInValue(i);

        if (items[i].sellIn < 0) {
            updateExpiredItem(i);
        }
    }

    private void updateExpiredItem(int i) {
        if (isAgedBrie(i)) {
            increaseQuality(i);
            return;
        } 
        if (isBackstagePass(i)) {
            backstagePassExpired(i);
            return;
        }
        decreaseQuality(i);
    }

    private boolean isBackstagePass(int i) {
        return items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(int i) {
        return items[i].name.equals("Aged Brie");
    }

    private boolean isSulfuras(int i) {
        return items[i].name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void backstagePassExpired(int i) {
        items[i].quality = 0;
    }

    private void increaseBackstagePassQuality(int i) {
        if (items[i].sellIn < 11) {
            increaseQuality(i);
        }
        if (items[i].sellIn < 6) {
            increaseQuality(i);
        }
    }

    private void decreaseQuality(int i) {
        if (items[i].quality > 0 && !isSulfuras(i)) {
                items[i].quality = items[i].quality - 1;
        }
    }

    private void decreaseSellInValue(int i) {
        if (!isSulfuras(i)) {
            items[i].sellIn = items[i].sellIn - 1;
        }
    }

    private void increaseQuality(int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;

            if (isBackstagePass(i)) {
                increaseBackstagePassQuality(i);
            }
        }
    }
}
