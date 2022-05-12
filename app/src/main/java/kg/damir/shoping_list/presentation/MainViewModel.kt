package kg.damir.shoping_list.presentation

import androidx.lifecycle.ViewModel
import kg.damir.shoping_list.data.ShopListRepositoryImpl
import kg.damir.shoping_list.domain.DeleteShopItemUseCase
import kg.damir.shoping_list.domain.EditShopItemUseCase
import kg.damir.shoping_list.domain.GetShopListUseCase
import kg.damir.shoping_list.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopList(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }


    fun changeEnabledState(shopItem: ShopItem){
        val newItem=shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}