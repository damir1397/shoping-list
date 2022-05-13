package kg.damir.shoping_list.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kg.damir.shoping_list.databinding.ItemShopDisabledBinding
import kg.damir.shoping_list.databinding.ItemShopEnabledBinding
import kg.damir.shoping_list.domain.ShopItem
import java.lang.RuntimeException

class ShopListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ShopItemEnabledViewHolder(val binding: ItemShopEnabledBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ShopItemDisabledViewHolder(val binding: ItemShopDisabledBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ENABLED -> {
                ShopItemEnabledViewHolder(
                    ItemShopEnabledBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            VIEW_TYPE_DISABLED -> {
                ShopItemDisabledViewHolder(
                    ItemShopDisabledBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
            }
            else -> {
                throw RuntimeException("Unknown view type: $viewType")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (shopList[position].enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    override fun getItemCount(): Int = shopList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_DISABLED -> {
                val view = holder as ShopItemDisabledViewHolder
                view.binding.tvName.text = shopList[position].name
                view.binding.tvCount.text = shopList[position].count.toString()
                view.itemView.setOnClickListener { true }
            }
            VIEW_TYPE_ENABLED -> {
                val view = holder as ShopItemEnabledViewHolder
                view.binding.tvName.text = shopList[position].name
                view.binding.tvCount.text = shopList[position].count.toString()
                view.itemView.setOnClickListener { true }
            }
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 0
        const val VIEW_TYPE_DISABLED = 1
        const val MAX_POOL_SIZE = 30
    }
}