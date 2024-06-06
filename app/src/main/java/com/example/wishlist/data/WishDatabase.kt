package com.example.wishlist.data

import androidx.room.Database
import androidx.room.RoomDatabase

//Here in entities we have to give data class name not table name
@Database(entities = [Wish::class], version = 1, exportSchema = false)
abstract class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}