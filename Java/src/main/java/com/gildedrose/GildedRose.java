package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                decreaseQuality(i);
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        increaseBackstagePassQuality(i);
                    }
                }
            }

            decreaseSellInValue(i);

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        decreaseQuality(i);
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    increaseQuality(i);
                }
            }
        }
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
        if (items[i].quality > 0) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }

    private void decreaseSellInValue(int i) {
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].sellIn = items[i].sellIn - 1;
        }
    }

    private void increaseQuality(int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }
}
