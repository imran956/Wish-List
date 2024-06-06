package com.example.wishlist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id:Long =0L,
    @ColumnInfo(name = "wish-title")
    var title:String = "",
    @ColumnInfo(name = "wish-description")
    var description:String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "title 1", description = "description 1"),
        Wish(title = "title 2", description = "description 2"),
        Wish(title = "title 3", description = "description 3")
    )

}
