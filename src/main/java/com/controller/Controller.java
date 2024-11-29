package com.controller;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class Controller {
    public static void main(String[] args) {
        GildedRose app = new GildedRose();

        app.clearInventory();
        initializeInventory(app);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        test(app, days);
    }

    private static void test(GildedRose app, int days) {
        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            printInventory(app);
            app.updateQuality();
        }
    }

    private static void printInventory(GildedRose app) {
        System.out.println("name, sellIn, quality");
        for (Item item : app.getInventory()) {
            System.out.println(item);
        }
        System.out.println();
    }

    private static void initializeInventory(GildedRose app) {
        for (Item item : generateItems()) {
            app.addItem(item);
        }
    }

    private static Item[] generateItems() {
        return new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)};
    }
}
