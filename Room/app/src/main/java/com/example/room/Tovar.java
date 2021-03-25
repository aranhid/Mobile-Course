package com.example.room;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Locale;

@Entity(tableName = "goods")
class Tovar {
    @PrimaryKey
    @NonNull
    int _id;
    String category, item;

    public Tovar(int _id, String category, String item) {
        this._id = _id;
        this.category = category;
        this.item = item;
    }

    @Override
    public String toString() { return String.format(Locale.getDefault(), "%s", category); }

}
