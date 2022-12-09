package com.arafat1419.mylibrary.camerax

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.arafat1419.mylibrary.databinding.ItemFilterBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FilterAdapter : RecyclerView.Adapter<FilterAdapter.ViewHolder>() {
    private var listData = ArrayList<FilterModel>()

    var onItemClicked: ((news: FilterModel) -> Unit)? = null

    fun setData(newListData: List<FilterModel>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemsDataBinding =
            ItemFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsDataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ViewHolder(private val binding: ItemFilterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: FilterModel) {
            with(binding) {
                setBackgroundTint(fabFilter, data.backgroundColor)

                itemView.setOnClickListener {
                    onItemClicked?.invoke(data)
                }
            }
        }

        private fun setBackgroundTint(fab: FloatingActionButton, color: Int) {
            fab.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(itemView.context, color)
            )
        }
    }
}