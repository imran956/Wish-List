package com.example.wishlist.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao:WishDao) {
    suspend fun addAWish(wish:Wish){
        wishDao.addAWish(wish)
    }
    suspend fun deleteAWish(wish:Wish){
        wishDao.deleteAWish(wish)
    }
    suspend fun updateAWish(wish:Wish){
        wishDao.updateAWish(wish)
    }
    fun getAWishById(id:Long): Flow<Wish> {
       return wishDao.getAWishById(id)
    }
   /* fun getAllWishes(): Flow<List<Wish>> {
       return wishDao.getAllWishes()
    }*/
    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

}