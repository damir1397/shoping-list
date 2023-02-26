package kg.damir.shoping_list.data

import androidx.room.Entity

@Entity(tableName = "shop_items")
data class ShopItemDbModel(
    var id: Int ,
    var name: String,
    var count: Int,
    var enabled: Boolean

)