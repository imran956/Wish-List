package com.example.wishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishViewModel: ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun updateWishTitle(title: String) {
        wishTitleState = title
    }

    fun updateWishDescription(description: String) {
        wishDescriptionState = description
    }
}