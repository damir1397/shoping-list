package kg.damir.shoping_list.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.damir.shoping_list.databinding.ItemShopEnabledBinding
import kg.damir.shoping_list.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ShopItemViewHolder(val binding: ItemShopEnabledBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder =
        ShopItemViewHolder(
            ItemShopEnabledBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.binding.tvName.text = shopList[position].name
        holder.binding.tvCount.text = shopList[position].id.toString()
        holder.itemView.setOnClickListener { true }
    }

    override fun getItemCount(): Int = shopList.size
}