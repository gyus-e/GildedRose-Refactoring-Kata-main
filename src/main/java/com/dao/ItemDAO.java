package com.dao;

import com.gildedrose.ItemForSale;

import java.util.ArrayList;

public interface ItemDAO {
    void insertItem(ItemForSale i);

    void removeItem(ItemForSale i);

    void updateItem(ItemForSale i);

    public ArrayList<ItemForSale> getInventory();

    void truncateTable();
}
