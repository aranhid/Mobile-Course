package com.example.room;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
interface ItemsList {

    @Query("SELECT * FROM goods")
    List<Tovar> selectAll();

}
