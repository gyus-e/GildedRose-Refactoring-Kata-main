package com.gildedrose;

import com.dao.ItemDAO;
import com.dao.ItemDAOFactory;

import java.util.ArrayList;

/**
 * Manages inventory and database
 */
public class GildedRose {
    ItemDAO db = ItemDAOFactory.getItemDAO();
    ArrayList<ItemForSale> inventory = db.getInventory();

    /**
     * Default constructor
     */
    public GildedRose() {
    }

    /**
     * Legacy constructor, adds array of items to inventory and database
     *
     * @param items
     */
    public GildedRose(Item[] items) {
        for (Item i : items) {
            addItem(i.name, i.sellIn, i.quality);
        }
    }

    /**
     * Updates quality of all items in inventory and database
     */
    public void updateQuality() {
        for (ItemForSale item : inventory) {
            item.updateQuality();
            db.updateItem(item);
        }
        inventory = db.getInventory();
    }

    /**
     * Returns inventory
     *
     * @return inventory
     */
    public ArrayList<ItemForSale> getInventory() {
        return inventory;
    }

    /**
     * Creates item with specified parameters and adds it to inventory and database
     *
     * @param name
     * @param sellIn
     * @param quality
     */
    public void addItem(String name, int sellIn, int quality) {
        ItemForSale newItem = ItemFactory.getItemForSale(name, sellIn, quality);
        inventory.add(newItem);
        db.insertItem(newItem);
    }

    /**
     * Adds already created item to inventory and database
     *
     * @param item
     */
    public void addItem(Item item) {
        addItem(item.name, item.sellIn, item.quality);
    }

    /**
     * Remove item with known id from inventory and database
     *
     * @param item
     */
    public void removeItem(ItemForSale item) {
        inventory.remove(item); //runtime exception
        db.removeItem(item);
    }

    /**
     * Remove item from inventory and database without knowing its id.
     * Extremely slow.
     *
     * @param item
     */
    public void removeItem(Item item) {
        for (ItemForSale inventoryItem : inventory) {
            if (inventoryItem.name.equals(item.name) && inventoryItem.sellIn == item.sellIn && inventoryItem.quality == item.quality) {
                removeItem(inventoryItem);
            }
        }
    }

    /**
     * Clears inventory
     */
    public void clearInventory() {
        inventory.clear();
        db.truncateTable();
    }
}
