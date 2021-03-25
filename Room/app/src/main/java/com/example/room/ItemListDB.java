package com.example.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={Tovar.class}, version=4)
public abstract class ItemListDB extends RoomDatabase {
    abstract ItemsList list();

    private static final String DB_NAME="goods.db";
    private static volatile ItemListDB INSTANCE=null;

    synchronized static ItemListDB get(Context ctxt) {

        if (INSTANCE==null) {
            INSTANCE=create(ctxt, false);
        }
        return(INSTANCE);
    }

    static ItemListDB create(Context ctxt, boolean memoryOnly) {
        RoomDatabase.Builder<ItemListDB> b;
        if (memoryOnly) {
            b = Room.inMemoryDatabaseBuilder(ctxt.getApplicationContext(),
                    ItemListDB.class);
        }
        else {
            b=Room.databaseBuilder(ctxt.getApplicationContext(), ItemListDB.class,
                    DB_NAME);
        }
        return(b.build());
    }
}