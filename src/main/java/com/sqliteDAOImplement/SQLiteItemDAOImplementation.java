package com.sqliteDAOImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.ItemDAO;
import com.gildedrose.ItemFactory;
import com.gildedrose.ItemForSale;

public class SQLiteItemDAOImplementation extends SQLiteDatabase implements ItemDAO {
	
	public SQLiteItemDAOImplementation() {
		super();
	}

	@Override
	public void insertItem(ItemForSale i) {
		executeQuery("INSERT INTO Items VALUES ("
			+ "\"" + i.name + "\","
			+ i.sellIn + ", "
			+ i.quality	+ ", "
			+ "\"" + i.getID()	+ "\");"
			);
	}

	@Override
	public void removeItem(ItemForSale i) {
		executeQuery("DELETE FROM Items WHERE id = '" + i.getID() + "'");
	}

	@Override
	public void updateItem(ItemForSale i) {
		executeQuery("UPDATE Items SET"
				+" sellIn = " + i.sellIn
				+", quality = "	+ i.quality
				+" WHERE id = \""	+ i.getID() + "\"" 
				);
	}
	
	@Override
	public ArrayList<ItemForSale> getInventory() {
		ArrayList<ItemForSale> inventory = new ArrayList<ItemForSale>();
		ResultSet rs = getQueryResultSet("SELECT name, sellIn, quality, id FROM Items");
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				int sellIn = rs.getInt("sellIn");
				int quality = rs.getInt("quality");
				String id = rs.getString("id");
				inventory.add(ItemFactory.getItemForSale(name, sellIn, quality, id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inventory;
	}
	
	public void truncateTable() {
		executeQuery("DELETE FROM Items");
	}
}
