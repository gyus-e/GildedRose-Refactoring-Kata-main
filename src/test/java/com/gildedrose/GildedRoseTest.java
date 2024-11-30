package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void manaCakeUpdateQualityBeforeExpiration() {
        GildedRose app = new GildedRose();
        app.addItem(new Item("Conjured Mana Cake", 10, 20));
        app.updateQuality();
        assertEquals(18, app.getInventory().get(app.getInventory().size() - 1).quality);
    }

    @Test
    void manaCakeUpdateQualityAfterExpiration() {
        GildedRose app = new GildedRose();
        app.addItem(new Item("Conjured Mana Cake", 0, 20));
        app.updateQuality();
        assertEquals(16, app.getInventory().get(app.getInventory().size() - 1).quality);
    }

    @Test
    void addItem() {
        GildedRose app = new GildedRose();
        app.addItem(new Item("Conjured Mana Cake", 0, 20));
        assertTrue(app.getInventory().get(app.getInventory().size() - 1).name.equals("Conjured Mana Cake"));
    }
}
