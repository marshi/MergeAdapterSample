package dev.marshi.android.mergeadaptersample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.marshi.android.mergeadaptersample.databinding.ItemBinding

val callback = object : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}

class MyAdapter : ListAdapter<Item, VH>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemBinding = DataBindingUtil.inflate<ItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item,
            parent,
            false
        )
        return VH(itemBinding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemViewBinding.text.text = getItem(position).value
    }
}

class VH(val itemViewBinding: ItemBinding) : RecyclerView.ViewHolder(itemViewBinding.root)

data class Item(val value: String)
