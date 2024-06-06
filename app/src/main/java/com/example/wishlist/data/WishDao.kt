package com.example.wishlist.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
abstract class WishDao {
    @Insert
    abstract fun addAWish(wish: Wish)

    abstract fun deleteAWish(wish: Wish)
}