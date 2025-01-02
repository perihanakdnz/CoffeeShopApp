package com.example.mobil_prog_odev;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DrinkDao {
    @Query("SELECT * FROM drinks")
    List<Drink> getAllDrinks();

    @Insert
    void insertAll(Drink... drinks);
} 