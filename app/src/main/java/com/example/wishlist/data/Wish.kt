package com.example.wishlist.data

data class Wish(
    val id:Long =0L,
    var title:String = "",
    var description:String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "title 1", description = "description 1"),
        Wish(title = "title 2", description = "description 2"),
        Wish(title = "title 3", description = "description 3")
    )

}
