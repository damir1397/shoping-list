package kg.damir.shoping_list.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem) {
       shopListRepository.editShopItem(shopItem)
    }
}