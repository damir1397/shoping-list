package kg.damir.shoping_list.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_items")
data class ShopItemDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int ,
    var name: String,
    var count: Int,
    var enabled: Boolean
)