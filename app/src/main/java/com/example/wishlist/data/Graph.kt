package com.example.wishlist.data

import android.content.Context
import androidx.room.Room

object Graph {
    lateinit var database: WishDatabase

    //This line of code uses the by lazy delegate to initialize the wishRepository property lazily.
    // When the property is first accessed, it creates an instance of the WishRepository class using
    // the wishDao property of the database object.
    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}