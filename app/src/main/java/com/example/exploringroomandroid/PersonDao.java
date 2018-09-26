package com.example.exploringroomandroid;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Query("SELECT * FROM person where name LIKE  :firstName ")
    Person findByName(String firstName);

    @Query("SELECT COUNT(*) from person")
    int countUsers();

    @Insert
    void insertAll(Person... users);

    @Delete
    void delete(Person user);
}
