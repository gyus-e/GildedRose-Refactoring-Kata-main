package com.controller;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.ItemForSale;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static int i = 1;
    private static final GildedRose app = new GildedRose();

//    public static void main(String[] args) {
//        initializeInventory();
//        test();
//    }

    public static void printInventory() {
        System.out.println("-------- day " + i++ + " --------");
        System.out.println("name, sellIn, quality");
        for (Item item : app.getInventory()) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static ArrayList<String> getInventoryStringList() {
        ArrayList<String> inventoryStringList = new ArrayList<String>();
        inventoryStringList.add("name, sellIn, quality");
        for (ItemForSale i : app.getInventory()) {
            inventoryStringList.add(i.toString());
        }
        return inventoryStringList;
    }

    public static void addItem(Item item) {
        app.addItem(item);
    }

    public static void removeItem(Item item) {
        app.removeItem(item);
    }

    public static void updateQuality() {
        app.updateQuality();
    }

    public static void initializeInventory() {
        app.clearInventory();
        for (Item item : generateItems()) {
            addItem(item);
        }
    }

    private static void test() {
        Scanner scanner = new Scanner(System.in);
        do{
            updateQuality();
            printInventory();
        } while (scanner.nextLine().isEmpty());
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
