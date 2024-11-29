package com.dao;

import com.sqliteDAOImplement.SQLiteItemDAOImplementation;

public class ItemDAOFactory {

    public static ItemDAO getItemDAO() {
        return new SQLiteItemDAOImplementation();
    }

}
