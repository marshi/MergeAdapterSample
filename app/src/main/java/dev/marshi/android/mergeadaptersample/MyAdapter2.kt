package dev.marshi.android.mergeadaptersample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.marshi.android.mergeadaptersample.databinding.Item2Binding

class MyAdapter2 : RecyclerView.Adapter<VH2>() {

    private val items: MutableList<Item2> = mutableListOf()

    fun add(item: Item2) {
        items.add(item)
    }

    fun addAll(item: List<Item2>) {
        items.addAll(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH2 {
        val itemBinding = DataBindingUtil.inflate<Item2Binding>(
            LayoutInflater.from(parent.context),
            R.layout.item2,
            parent,
            false
        )
        return VH2(itemBinding)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: VH2, position: Int) {
        holder.itemViewBinding.text.text = items[position].value
    }
}

class VH2(val itemViewBinding: Item2Binding) : RecyclerView.ViewHolder(itemViewBinding.root)

class Item2(val value: String)
