package com.example.wishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wishlist.data.Graph
import com.example.wishlist.data.Wish
import com.example.wishlist.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
) : ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun updateWishTitle(title: String) {
        wishTitleState = title
    }

    fun updateWishDescription(description: String) {
        wishDescriptionState = description
    }

    //Here we need to add lateinit because it is promise that we will get that variable that is used in it.
    //As Flow works in background it will take time to get the data from database.That's why lateinit is used.
    //generally lateinit is used when we call coroutine or suspend function.
    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish) {
        //Dispatchers.IO is used to enhance the performance of the application.
        // It will tell on which thread this funtion has to run in this way reduce CPU usage.
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAWish(wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish)
        }
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish)
        }
    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishRepository.getAWishById(id)
    }
}