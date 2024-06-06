package com.example.wishlist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
abstract class WishDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    //This Query is written for getting a list of Wishes from table wish-table
    //This flow is from jetbrain not of concurrent
    @Query("SELECT * FROM `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWishById(id:Int): Flow<Wish>

}