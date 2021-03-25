package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    DBHelperWithLoader loader;
    SQLiteDatabase database;
    Cursor cursor;
    Cursor itemCursor;

    ItemListDB itemDB;
    Cursor roomCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //===================================================================================

        /*loader = new DBHelperWithLoader(this);
        database = loader.getWritableDatabase();

        cursor = database.rawQuery("SELECT * FROM goods", null);
        ListView category = findViewById(R.id.categories);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, cursor, 0);
        category.setAdapter(categoryAdapter);
        ListView listView = findViewById(R.id.goods);
        ItemAdapter itemAdapter = new ItemAdapter(this, cursor, 0);
        listView.setAdapter(itemAdapter);*/

        //===================================================================================

        itemDB = ItemListDB.create(this, false);
        roomCursor = itemDB.query("SELECT * FROM goods", null);

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, roomCursor, 0);
        ListView category = findViewById(R.id.categories);
        category.setAdapter(categoryAdapter);



//        setCategoryThread(roomCursor);

    }


    public void setCategoryThread(Cursor c) {
        Context ctx = getApplicationContext();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                CategoryAdapter categoryAdapter = new CategoryAdapter(ctx, c, 0);
                ListView category = findViewById(R.id.categories);
                category.setAdapter(categoryAdapter);
            }
        });

    }
}